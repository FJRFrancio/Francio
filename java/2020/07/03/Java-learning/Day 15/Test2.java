public class Test2 {
    public static void main(String[] args) {
        // �����˻�����
        Account a = new Account();

        // ���̶߳���
        User u_wechat = new User(a, 2000);
        User u_alipay = new User(a, 2000);

        Thread wechat = new Thread(u_wechat, "wechat");
        Thread alipay = new Thread(u_alipay, "alipay");

        wechat.start();
        alipay.start();
    }

}

class Account {
    public static int money = 3000;// ȫ�ֱ��������в�������

    /**
     * ���ǰҪ�ж�Ǯ������
     * 
     * @param m
     */

    public synchronized void drawing(int m) {// ������Synchronizedͬ����������ָ����
        String name = Thread.currentThread().getName();

        if (money < m) {
            System.out.println("lack of money,you only have " + money);// �˴��жϿ���ס
        } else {
            System.out.println(name + "Still have " + this.money);
            System.out.println("drawed " + m);

            money = money - m;
            System.out.println("after " + money);
        }

    }

    public synchronized void drawing1(int m) {// ������Synchronizedͬ����������ָ����
        String name = Thread.currentThread().getName();

        if (money < m) {
            System.out.println("lack of money,you only have " + money);// �˴��жϿ���ס
        } else {
            System.out.println(name + "Still have " + this.money);
            System.out.println("drawed " + m);

            money = money - m;
            System.out.println("after " + money);
        }

    }

    public static synchronized void drawing2(int m) {// ��̬������ͬ��������������еĶ�����ͬһ��
        String name = Thread.currentThread().getName();

        if (money < m) {
            System.out.println("lack of money,you only have " + money);// �˴��жϿ���ס
        } else {
            System.out.println(name + "Still have " + money);
            System.out.println("drawed " + m);

            money = money - m;
            System.out.println("after " + money);
        }

    }

    public void drawing3(int m) {// �������
        synchronized (this) {// this ��ʾ��ǰ�Ķ���Ĵ����.�������������Ҳ��synchronized(this)�Ĵ���飬ʹ�õ���ͬһ��ͬ������
            String name = Thread.currentThread().getName();

            if (money < m) {
                System.out.println("lack of money,you only have " + money);// �˴��жϿ���ס
            } else {
                System.out.println(name + "Still have " + this.money);
                System.out.println("drawed " + m);

                money = money - m;
                System.out.println("after " + money);
            }

        }
    }

    /**
     * ��Ҫ����ͬ�Ķ���Ӳ�ͬ�������Ӷ������
     * 
     * @param m
     */
    public void drawing4(int m, Account a) {// �������
        synchronized (a) {// �����ݽ����Ķ������,��ͬ������в�ͬ��ͬ������
            String name = Thread.currentThread().getName();

            // ����֧����������΢�Ų���
            if (name.equals("wechat")) {
                try {
                    a.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if(money<m){
                System.out.println("lack of money,you only have " + money);//�˴��жϿ���ס
            }else{
                System.out.println(name + "Still have " + this.money);
                System.out.println("drawed " + m);

                money = money - m;
                System.out.println("after " + money);
            }
        if (name.equals("alipay")) {
            try {
                a.notify();//����ǰ��wait���߳�
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
        // if(Thread.currentThread().getName().equals("wechat")){//�ܲ�ͬ�ķ�����ͬ������Ȼ���Կ�ס
        //     account.drawing(money);
        // }else{
        //     account.drawing1(money);
        // }
        
        //account.drawing2(money);//��̬����
        //account.drawing3(money);
        account.drawing4(money, account);


    }
}