public class Person {
    String name;
    static int age;
    static TestPerson tp = new TestPerson();

    public Person(){
        this.name = "zhangsan";
        System.out.println("构造方法");
    }

    {//这是一个非静态的代码块,优先执行
        System.out.println("执行的是非静态代码块");
    }

    static {
        //这里只能使用静态修饰的属性和方法
        age = 1;
        showAge();
        System.out.println("=====执行的是静态代码块====");
        tp.age = 1;
    }

    public static void showAge(){
        System.out.println(age);
    }
    
    public void test(){
        System.out.println("test method in person class");
    }



}