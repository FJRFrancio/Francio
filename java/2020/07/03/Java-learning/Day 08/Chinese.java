public class Chinese {
    public Chinese(){
        this.count += 1;
    }

    static String country;//类变量，不用实例化，直接通过类名.属性名即可使用，是类的一部分，被所有这个类的实例化对象共享，也可叫做静态变量
    String name;//实例变量：只有实例化后才可使用，属于实例化对象的一部分，不能共用
    int age;
    public static int count;//记录到底被new了多少次 
    
    public static void test(){
        System.out.println("this is a static method");//静态方法
    }

    public static void showCount(){
        System.out.println(Chinese.count);
    }
    
}