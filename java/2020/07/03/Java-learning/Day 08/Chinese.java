public class Chinese {
    public Chinese(){
        this.count += 1;
    }

    static String country;//�����������ʵ������ֱ��ͨ������.����������ʹ�ã������һ���֣�������������ʵ����������Ҳ�ɽ�����̬����
    String name;//ʵ��������ֻ��ʵ������ſ�ʹ�ã�����ʵ���������һ���֣����ܹ���
    int age;
    public static int count;//��¼���ױ�new�˶��ٴ� 
    
    public static void test(){
        System.out.println("this is a static method");//��̬����
    }

    public static void showCount(){
        System.out.println(Chinese.count);
    }
    
}