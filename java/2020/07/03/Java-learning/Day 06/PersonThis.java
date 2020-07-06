

public class PersonThis{
    public PersonThis(){

    }

    public PersonThis(int age){
        this.age = age;
    }

    public PersonThis(String name){
        this();//用this（）调用无参构造器PersonThis()；使用this()必须放在构造器首行！！
        this.name = name;
    }

    public PersonThis(int age, String name){//this用于区分同名的当前类成员变量和形参
        this(1);//用this（xx）直接调用含参构造器PersonThis(int age)
        this.age = age;
        this.name = name;
    }
    int age;
    String name;

    public void setName(String name){
        this.name = name;
    }

    public void setName1(String name){//类中的方法也可以用this调用
        this.setName(name);
    }

    public void showInfo(){
        System.out.println(this.name);//明确标识出输出的为类成员变量name，防止混淆。增强程序的阅读性
    }

}