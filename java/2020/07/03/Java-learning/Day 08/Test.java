

public class Test{
    public static void main(String[] args) {
        //Student s = new Student();
       // Person p = s;//��������࣬���Զ�����

       // Person pe = new Person();
       // Student st = (Student) pe;//ǿ��ת��

        // Test t = new Test();
        // t.method(new Person());
        // t.method(new Student());

        // Order o1 = new Order(123,"a001");
        // Order o2 = new Order(123,"a001");
        // Order o3 = new Order(123,"a002");

        // System.out.println(o1.equals(o2));
        // System.out.println(o1.equals(o3));

        // Integer i = new Integer(111);//װ��
        // Integer i1 = 112;//�Զ�װ��
        // System.out.println(i);

        // int i0 = i.intValue();//���䣬�õ�������������
        // int i2 = i1;//�Զ�����

        // int i = Integer.parseInt("123");
        // float f = Float.parseFloat("0.40");//�ַ���ת������������

        // String istr = String.valueOf(i);//������������ת�ַ���

        // MyDate m = new MyDate(2030,12,12);
        // System.out.println(m.toString());
        // System.out.println(m);//��ӡm�����൱�ڴ�ӡm.toString()

        // Chinese c = new Chinese();
        // //c.country = "china";
        // Chinese.country = "china";//��ststic�ı���ֻ����дһ�Σ�������.����ֱ�ӷ��ʣ��ֳ�Ϊ�����
        // c.name = "xx";
        // c.age = 11;//д�������ʱ�����ظ����֡�China����ʹ��ststic���Թ̶�China���ԣ�
        // Chinese.test();

        // String s = "11";
        // if (s != null && !s.equals("")){//�ж��ַ����Ƿ�Ϊ�գ����ж��ǲ���null��ͬʱ�ǲ��ǡ���
        //     //��δ���Ŀ����п��ܻ���ʹ�������жϣ��ʿ�д�ɹ�����
        // }
        // System.out.println(Utils.isEmpty(s));//ʹ�ù�����
        
        // //������֪��new�˶��ٸ�Chinese����
        // Chinese c1 = new Chinese();
        // Chinese c2 = new Chinese();
        // Chinese c3 = new Chinese();
        // Chinese c4 = new Chinese();
        // Chinese c5 = new Chinese();

        // Chinese.showCount();

        //Single s = new Single();//�����ã���������˽�л�
        // Single s1 = Single.getInstance();
        // Single s2 = Single.getInstance();
        // Single s3 = Single.getInstance();
        // Single s4 = Single.getInstance();//���ܵ��ü���,���õĶ���˽�е��������ststic������ζ�Ÿö���ֻ��ʵ������һ�Ρ�

        Single1 s1 = Single1.getInstance();//��һ��ִ��ʱ��newһ����̬�Ķ���
        Single1 s2 = Single1.getInstance();
        Single1 s3 = Single1.getInstance();
        Single1 s4 = Single1.getInstance();//���ܵ��ü���,���õĶ���˽�е��������ststic������ζ�Ÿö���ֻ��ʵ������һ�Ρ�


    }

    

    public void method(Person e) {
        //e.getSchool();//no such method
        if (e instanceof Student){//�����ǲ�����������ϵ
            Student s = (Student)e;
            s.getSchool();
        }else{
            e.test();
        }
    }
}