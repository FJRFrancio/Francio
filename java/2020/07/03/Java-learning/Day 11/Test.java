import java.util.ArrayList;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1111);
        list.add(true);
        list.add("abc");//不指定泛型，可以存各种类型的数据

        //需求：只能在集合中存字符串
        List<String> l = new ArrayList<String>();
        l.add("a");
        //l.add(1);//只能填字符串，编译期即可发现问题、

        A<String> a1 = new A<String>();//在new A的对象指定了泛型
        a1.setKey("xxxx");//对象使用的set方法中key的形参即变为String类型。
        String s = a1.getKey();

        A<Integer> a2 = new A<Integer>();
        a2.setKey(1);//对象使用的set方法中key的形参即变为Integer类型。
        Integer s2 = a2.getKey();

        A a3 = new A();//不指名泛型，默认Object
        a3.setKey(1);
        Object s3 = a3.getKey();
        
        //同样的类，但在new对象时泛型指定了不同的数据类型，这些对象不能互相赋值
        //a1 = a2;//不能互相赋值

    }
}
/**
 * 此处的泛型T可以任意的取名。
 * @param <T>
 */
class A<T>{//定义了一个不知道啥类型的泛型T,使用时传进来一个数据类型
    private T key;

    public void setKey(T key){
        this.key = key;
    }

    public T getKey(){
        return this.key;
    }
}