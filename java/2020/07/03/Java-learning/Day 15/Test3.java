/**
 * ��������������
 */
public class Test3 {
    public static void main(String[] args) {
        Clerk c = new Clerk();

        // ����ʱ������������ʱ������
        // ������
        new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (args) {
                    while (true) {
                        // ����ѭ������������������
                        if (c.productNum == 0) {
                            // �����Ʒ��Ϊ0����ʼ����
                            System.out.println("start");
                            while (c.productNum < 4) {
                                c.productNum ++;//�ӿ��
                                System.out.println("have" + c.productNum);
                            }
                            System.out.println("over at " + c.productNum);
                            c.notify();//����������
                        } else {
                            try {
                                c.wait();//�������ߵȴ�
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
                        // ����ѭ�������������Ѵ���
                        if (c.productNum == 4) {
                            // �����Ʒ��Ϊ4����ʼ����
                            System.out.println("start");
                            while (c.productNum >0) {
                                c.productNum -= 1 ;//���ѿ��
                                System.out.println("have" + c.productNum);
                            }
                            System.out.println("over at " + c.productNum);
                            c.notify();//����������
                        } else {
                            try {
                                c.wait();//�������ߵȴ�
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