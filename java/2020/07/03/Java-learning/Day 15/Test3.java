/**
 * 生产者与消费者
 */
public class Test3 {
    public static void main(String[] args) {
        Clerk c = new Clerk();

        // 消费时不生产，生产时不消费
        // 生产者
        new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (args) {
                    while (true) {
                        // 无限循环代表无限生产次数
                        if (c.productNum == 0) {
                            // 如果商品数为0，开始生产
                            System.out.println("start");
                            while (c.productNum < 4) {
                                c.productNum ++;//加库存
                                System.out.println("have" + c.productNum);
                            }
                            System.out.println("over at " + c.productNum);
                            c.notify();//唤醒消费者
                        } else {
                            try {
                                c.wait();//让生产者等待
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            
                        }
                    }

                }
            }
        },"perducer").start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (args) {
                    while (true) {
                        // 无限循环代表无限消费次数
                        if (c.productNum == 4) {
                            // 如果商品数为4，开始消费
                            System.out.println("start");
                            while (c.productNum >0) {
                                c.productNum -= 1 ;//消费库存
                                System.out.println("have" + c.productNum);
                            }
                            System.out.println("over at " + c.productNum);
                            c.notify();//唤醒生产者
                        } else {
                            try {
                                c.wait();//让消费者等待
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            
                        }
                    }

                }
            }
        },"custom").start();
    }
}


class Clerk{
    public static int productNum = 0;
}