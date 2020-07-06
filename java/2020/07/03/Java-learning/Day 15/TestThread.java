/**
 * 继承Thread类的方式实现多线程
 */

public class TestThread extends Thread {
    @Override
    public void run() {
        System.out.println("main code");
        for (int i = 0;i<5;i++){
            System.out.println(i);
        }
    }
}