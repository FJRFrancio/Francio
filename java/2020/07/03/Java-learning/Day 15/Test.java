public class Test{
    public static void main(String[] args) {
        Thread t0 = new TestThread();//�̳�Thread����߳�
        t0.start();//�����߳�

        Thread t1 = new TestThread();//�߳̿����������
        t1.start();

        Thread t3 = new Thread(new TestRunnable());//�������Ϊһ��Runnableʵ��
        t3.start();

        Thread t4 = new Thread(new TestRunnable(), "t-1");//�ڶ�������Ϊ������߳�����


        Runnable run = new TestRunnable();
        Thread t5 = new Thread(run, "t-2");
        Thread t6 = new Thread(run, "t-3");//�����̹߳�ͬʹ��ͬһ��runʵ��



        System.out.println("---------------");
        System.out.println("---------------");
        System.out.println("---------------");


        /**
         *  ���߼����߳���run�������ӡ��������˳���ҵ���
         * ��ʱ������main������t0.start�еķ����������У����Ա����Լ������˳�򣬵��������ҵ�
         * �˼����̵߳��첽��
         */
    }
}