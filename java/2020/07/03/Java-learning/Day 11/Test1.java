public class Test1 {
    public static void main(String[] args) {
        B1<Object> b1 = new B1<Object>();//B1在使用时需要添加泛型

        B2 b2 = new B2();//B2在类中已经确定了泛型，故不需要指定泛型

        Cc<Object> c  = new Cc<Object>();
        c.test2("xxx");
        //泛型方法在调用之前没有固定的数据类型，在调用时，传入的参数是什么类型就会把泛型给成什么类型。
        Boolean b = c.test3(true);
        Integer i = c.test3(1323);//泛型方法使用时可随意传入数据，传入后数据类型即确定。

    }
    
}

interface IB<T>{//带泛型的接口
    T test(T t);
}

class B1<T> implements IB<T>{//未传入泛型实参，类还是使用泛型，没有实际指定类型，与接口一致。

    @Override
    public T test(T t) {
        // TODO Auto-generated method stub
        return t;
    }
    
}
/**
 * 如果实现接口时指定接口的泛型数据具体类型
 * 这个类实现接口所有方法的位置都要将泛型替换成实际数据类型。
 */

class B2 implements IB<String>{

    @Override
    public String test(String t) {//传入泛型实参，重写部分泛型全部改名
        // TODO Auto-generated method stub
        return null;
    }
    
}

class Cc<E>{
    private E e;

    public static <T> void test5(T t){
        System.out.println(this.e);//注意：静态方法不能使用类上定义的泛型。
        System.out.println(t);//如果要使用泛型，只能用静态方法自己定义的泛型
    }


    public void test(String s){//普通方法

    }

    public <T> void test2(T s){//泛型方法
        T t = s;
        System.out.println(this.e);//在类上定义的泛型可以在普通方法中使用

    }

    public String test1(String s){//有返回值普通方法
        return s;
    }

    public <T> T test3(T s){//有返回值的泛型方法
        return s;
    }

    public void test4(String...strs){//可变参数的普通方法
        for(String s : strs){
            System.out.println(s);
        }
    }

    public <T> void test4(T...strs){//可变参数的泛型方法
        for(T s : strs){
            System.out.println(s);
        }
    }
}