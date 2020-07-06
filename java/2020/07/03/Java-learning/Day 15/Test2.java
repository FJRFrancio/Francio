public class Test2 {
    public static void main(String[] args) {
        // 定义账户对象
        Account a = new Account();

        // 多线程对象
        User u_wechat = new User(a, 2000);
        User u_alipay = new User(a, 2000);

        Thread wechat = new Thread(u_wechat, "wechat");
        Thread alipay = new Thread(u_alipay, "alipay");

        wechat.start();
        alipay.start();
    }

}

class Account {
    public static int money = 3000;// 全局变量，所有操作共享

    /**
     * 提款前要判断钱够不够
     * 
     * @param m
     */

    public synchronized void drawing(int m) {// 若不加Synchronized同步锁，会出现负金额
        String name = Thread.currentThread().getName();

        if (money < m) {
            System.out.println("lack of money,you only have " + money);// 此处判断卡不住
        } else {
            System.out.println(name + "Still have " + this.money);
            System.out.println("drawed " + m);

            money = money - m;
            System.out.println("after " + money);
        }

    }

    public synchronized void drawing1(int m) {// 若不加Synchronized同步锁，会出现负金额
        String name = Thread.currentThread().getName();

        if (money < m) {
            System.out.println("lack of money,you only have " + money);// 此处判断卡不住
        } else {
            System.out.println(name + "Still have " + this.money);
            System.out.println("drawed " + m);

            money = money - m;
            System.out.println("after " + money);
        }

    }

    public static synchronized void drawing2(int m) {// 静态方法加同步锁，则对于所有的对象都是同一个
        String name = Thread.currentThread().getName();

        if (money < m) {
            System.out.println("lack of money,you only have " + money);// 此处判断卡不住
        } else {
            System.out.println(name + "Still have " + money);
            System.out.println("drawed " + m);

            money = money - m;
            System.out.println("after " + money);
        }

    }

    public void drawing3(int m) {// 锁代码块
        synchronized (this) {// this 表示当前的对象的代码块.如果其他方法中也有synchronized(this)的代码块，使用的是同一个同步锁。
            String name = Thread.currentThread().getName();

            if (money < m) {
                System.out.println("lack of money,you only have " + money);// 此处判断卡不住
            } else {
                System.out.println(name + "Still have " + this.money);
                System.out.println("drawed " + m);

                money = money - m;
                System.out.println("after " + money);
            }

        }
    }

    /**
     * 想要给不同的对象加不同的锁：加对象参数
     * 
     * @param m
     */
    public void drawing4(int m, Account a) {// 锁代码块
        synchronized (a) {// 给传递进来的对象加锁,不同对象就有不同的同步锁。
            String name = Thread.currentThread().getName();

            // 需求：支付宝优先于微信操作
            if (name.equals("wechat")) {
                try {
                    a.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if(money<m){
                System.out.println("lack of money,you only have " + money);//此处判断卡不住
            }else{
                System.out.println(name + "Still have " + this.money);
                System.out.println("drawed " + m);

                money = money - m;
                System.out.println("after " + money);
            }
        if (name.equals("alipay")) {
            try {
                a.notify();//唤醒前面wait的线程
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        }
    }
}


class User implements Runnable{
    Account account;
    int money;
    
    public User(Account account,int money){
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
        // if(Thread.currentThread().getName().equals("wechat")){//跑不同的方法，同步锁仍然可以卡住
        //     account.drawing(money);
        // }else{
        //     account.drawing1(money);
        // }
        
        //account.drawing2(money);//静态方法
        //account.drawing3(money);
        account.drawing4(money, account);


    }
}