/**
 * ͨ��ʵ��Runnable�ӿ�ʵ�ֶ��߳�
 */

public class TestRunnable implements Runnable{

    int count = 0;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());//��ȡ�߳�����
        System.out.println("main code");
        for (int i = 0;i<5;i++){
            System.out.println("Runnable " + i);
            count++;
            System.out.println(count);
        }
    }
    
    
}