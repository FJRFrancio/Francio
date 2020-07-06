public class Test1 {
    public static void main(String[] args) {
        TestRun run0 = new TestRun();
        TestRun run1 = new TestRun();

        Thread t0 = new Thread(run0);
        Thread t1 = new Thread(run1);

        t0.setPriority(1);//设置线程的优先级
        t1.setPriority(10);

        t0.start();
        t1.start();

        t0.setName("t0");

        System.out.println(t0.getName());//返回线程名称
        System.out.println(t0.getPriority())//获取优先级

        /**
         * 优先级界定了在系统中运行多个代码时那个代码会有较大的概率被执行。
         * 用数字表示，1-10，数字越大优先级越高，默认为5
         */

        t0.join();//相当于直接在这个位置插入run方法中的代码，此时执行不再异步，而是顺序执行
        /**
         * 专业说法：阻塞了当前的main方法，先执行join进来的线程的代码，join的线程执行完毕后继续执行之前main方法阻塞的代码
         */
        t1.stop();//强制终止线程
        t1.isAlive();//查看线程是否存活

    }
}

class TestRun implements Runnable {

    int count = 0;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());// 获取线程名称
        System.out.println("main code");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);// 每次循环睡眠1000毫秒，
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 

            if(i % 2 == 0){
                Thread.yield();//线程让步
            }
            
            System.out.println("Runnable " + i);
            count++;
            System.out.println(count);
        }

    }

}