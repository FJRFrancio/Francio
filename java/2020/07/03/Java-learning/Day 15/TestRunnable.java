/**
 * 通过实现Runnable接口实现多线程
 */

public class TestRunnable implements Runnable{

    int count = 0;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());//获取线程名称
        System.out.println("main code");
        for (int i = 0;i<5;i++){
            System.out.println("Runnable " + i);
            count++;
            System.out.println(count);
        }
    }
    
    
}