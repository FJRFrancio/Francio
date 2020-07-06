
/**
 * 懒汉式的单例模式
 */

public class Single1 {
    //私有化构造，让外界不能直接new
    private Single1(){

    }

    private static Single1 s1 = null;//与饿汉式区别

    public static Single1 getInstance(){
        if (s1 == null){//与饿汉式区别
            s1 = new Single1();
        }

        return s1;
    }
    
}