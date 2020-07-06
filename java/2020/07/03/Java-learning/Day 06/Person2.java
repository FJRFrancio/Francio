public class Person2 {
   //此处为构造器，当写了显式构造方法后就不会使用默认的构造
   //此处类似于python中的CONFIG
    public Person2(){
        age = 1;
        name = "zhangsan";
    }

    //此构造方法使得该类被调用时可以用Person2(xxx,"xxx")的方式赋值，无需实例化后用xxx.xxx = xxx 的方法赋值，此即带参数的构造方法
    public Person2(int a,String n){
        age = a;
        name = n;
    }
    
    public int age;
    public String name;
    public void showInfo(){
        System.out.println(age);
        System.out.println(name);
    }
}