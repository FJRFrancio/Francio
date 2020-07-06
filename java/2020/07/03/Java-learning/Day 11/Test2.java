import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        Dd d = new Dd();
        List<String> li = new ArrayList<String>();
        d.test(li);

        List<C1> lc = new ArrayList<C1>();
        d.test1(lc);

        List<B3> lb = new ArrayList<B3>();
        d.test1(lb);//报错：The method test1(List<? extends C1>) in the type Dd is not applicable for the arguments 
        d.test2(lb);//改成super后，不报错

        List<IAImpl> lia = new ArrayList<IAImpl>();
        d.test3(lia);
    }
    
}

class Dd{
    public void test(List<?> list){//test方法需要一个List集合的参数，但现在不确定List集合中存的数据类型是什么

    }

    public void test1(List<? extends C1> list){//List参数的元素数据类型是在C1及其子类之间

    }

    public void test2(List<? super C1> list){//List参数的元素数据类型是在C1及其父类之间

    }

    public void test3(List<? extends IA> list){//List参数的元素数据类型是IA的实现类

    } 
}

class A1{}

class B3 extends A1{}

class C1 extends B3{}

class D1 extends C1{}

interface IA {}

class IAImpl implements IA{}