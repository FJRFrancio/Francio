public class Test{
    public static void main(String[] args) {
        Thread t0 = new TestThread();//继承Thread类的线程
        t0.start();//启动线程

        Thread t1 = new TestThread();//线程可以启动多个
        t1.start();

        Thread t3 = new Thread(new TestRunnable());//传入参数为一个Runnable实例
        t3.start();

        Thread t4 = new Thread(new TestRunnable(), "t-1");//第二个参数为定义的线程名称


        Runnable run = new TestRunnable();
        Thread t5 = new Thread(run, "t-2");
        Thread t6 = new Thread(run, "t-3");//两个线程共同使用同一个run实例



        System.out.println("---------------");
        System.out.println("---------------");
        System.out.println("---------------");


        /**
         *  主逻辑与线程中run方法里打印出的数据顺序乱掉了
         * 此时代码中main方法与t0.start中的方法并行运行，各自保持自己的输出顺序，但总体是乱的
         * 此即多线程的异步性
         */
    }
}