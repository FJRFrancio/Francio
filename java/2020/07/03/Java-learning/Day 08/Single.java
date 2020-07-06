
/**
 * 实现一个饿汉式的单例模式
 */

public class Single{
    // public Single(){
    //     //假设构造器中药执行很多行代码，耗时很长，这种情况就适合使用单例模式，只new一次对象
    // }

    //先做私有的构造,构造方法私有化，调用这个类的人就不能直接使用new来创建对象
    private Single(){

    }

    //做一个私有的Single类型的类变量
    private static Single single = new Single();

    public static Single getInstance(){
        return single;
    }

}