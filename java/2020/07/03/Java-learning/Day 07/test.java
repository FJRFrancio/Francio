public class test {

    /**
     * 问题：想给Test方法设置一个形参，但该参数不确定到底会传进来一个什么类
     * 可以确定的是传递的实参一定会是一个类，那么Test方法的形参就要设置一个Object类，作为父类可以接收所有子类。
     */
    public void Test(Object obj){

    }

    public static void main(String[] args) {
        test t = new test();
        Person p = new Person();
        Student s = new Student();

        t.Test(p);
        t.Test(p);
        t.Test(new Kk());

        Person e = new Person();
        System.out.println(p.equals(e));//Object类中的方法：判断两个对象是否为同一个

        Object o = new Object();
        System.out.println(o.hashCode());//获取哈希值

        System.out.println(p.toString());//打印当前对象的内存地址
    }
}