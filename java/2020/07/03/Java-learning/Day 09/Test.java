public class Test{
    public static void main(String[] args) {
        CommonEmployee ce = new CommonEmployee();//
        ce.work();//
        ce.setCommonEmployeeInfo(123, "zhangsan", 456.321);//
        ce.getCommonEmployeeInfo();//
        // new Person();

        //�����ڲ���
        // Person p = new Person(){//������ʵ���Ϲ�����һ��û��������person�����࣬��������person�����ࡣû����������ζ�Ų�����new�ķ�����������û�й������� 
        //     //���Ҫ�ǻ��ڹ������г�ʼ�����ԣ���û�취�ˣ���ʱ��Ҫʹ�ô����{}����ʼ��������
        //     //�������name�ĳ�lisi�������붯Person�Ĵ���
        //     //�����������������person���������࣬�ʿ����������һ���������湹�췽��ʵ�ֳ�ʼ��
        //     {
        //         super.name = "lisi";
        //     }

        // @Override
        //     public void test() {
        //         System.out.println("======");
        //     }
        // };
        // System.out.println(p.name);
        // p.test();//ִ�е�����������д�ķ�����
            

    }
}