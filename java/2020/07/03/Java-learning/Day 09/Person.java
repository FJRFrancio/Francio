public class Person {
    String name;
    static int age;
    static TestPerson tp = new TestPerson();

    public Person(){
        this.name = "zhangsan";
        System.out.println("���췽��");
    }

    {//����һ���Ǿ�̬�Ĵ����,����ִ��
        System.out.println("ִ�е��ǷǾ�̬�����");
    }

    static {
        //����ֻ��ʹ�þ�̬���ε����Ժͷ���
        age = 1;
        showAge();
        System.out.println("=====ִ�е��Ǿ�̬�����====");
        tp.age = 1;
    }

    public static void showAge(){
        System.out.println(age);
    }
    
    public void test(){
        System.out.println("test method in person class");
    }



}