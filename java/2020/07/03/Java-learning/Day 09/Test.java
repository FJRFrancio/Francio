public class Test{
    public static void main(String[] args) {
        CommonEmployee ce = new CommonEmployee();//
        ce.work();//
        ce.setCommonEmployeeInfo(123, "zhangsan", 456.321);//
        ce.getCommonEmployeeInfo();//
        // new Person();

        //匿名内部类
        // Person p = new Person(){//这块代码实际上构建了一个没有类名的person的子类，即匿名的person的子类。没有类名就意味着不能用new的方法创建对象，没有构造器。 
        //     //如果要是还在构造器中初始化属性，就没办法了，此时就要使用代码块{}做初始化工作。
        //     //现在想把name改成lisi，但不想动Person的代码
        //     //由于这个大括号里是person的匿名子类，故可以在这里加一个代码块代替构造方法实现初始化
        //     {
        //         super.name = "lisi";
        //     }

        // @Override
        //     public void test() {
        //         System.out.println("======");
        //     }
        // };
        // System.out.println(p.name);
        // p.test();//执行的匿名子类重写的方法。
            

    }
}