public class Test1 {
    public static void main(String[] args) {
        TestRun run0 = new TestRun();
        TestRun run1 = new TestRun();

        Thread t0 = new Thread(run0);
        Thread t1 = new Thread(run1);

        t0.setPriority(1);//�����̵߳����ȼ�
        t1.setPriority(10);

        t0.start();
        t1.start();

        t0.setName("t0");

        System.out.println(t0.getName());//�����߳�����
        System.out.println(t0.getPriority())//��ȡ���ȼ�

        /**
         * ���ȼ��綨����ϵͳ�����ж������ʱ�Ǹ�������нϴ�ĸ��ʱ�ִ�С�
         * �����ֱ�ʾ��1-10������Խ�����ȼ�Խ�ߣ�Ĭ��Ϊ5
         */

        t0.join();//�൱��ֱ�������λ�ò���run�����еĴ��룬��ʱִ�в����첽������˳��ִ��
        /**
         * רҵ˵���������˵�ǰ��main��������ִ��join�������̵߳Ĵ��룬join���߳�ִ����Ϻ����ִ��֮ǰmain���������Ĵ���
         */
        t1.stop();//ǿ����ֹ�߳�
        t1.isAlive();//�鿴�߳��Ƿ���

    }
}

class TestRun implements Runnable {

    int count = 0;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());// ��ȡ�߳�����
        System.out.println("main code");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);// ÿ��ѭ��˯��1000���룬
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 

            if(i % 2 == 0){
                Thread.yield();//�߳��ò�
            }
            
            System.out.println("Runnable " + i);
            count++;
            System.out.println(count);
        }

    }

}