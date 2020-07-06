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
        d.test1(lb);//����The method test1(List<? extends C1>) in the type Dd is not applicable for the arguments 
        d.test2(lb);//�ĳ�super�󣬲�����

        List<IAImpl> lia = new ArrayList<IAImpl>();
        d.test3(lia);
    }
    
}

class Dd{
    public void test(List<?> list){//test������Ҫһ��List���ϵĲ����������ڲ�ȷ��List�����д������������ʲô

    }

    public void test1(List<? extends C1> list){//List������Ԫ��������������C1��������֮��

    }

    public void test2(List<? super C1> list){//List������Ԫ��������������C1���丸��֮��

    }

    public void test3(List<? extends IA> list){//List������Ԫ������������IA��ʵ����

    } 
}

class A1{}

class B3 extends A1{}

class C1 extends B3{}

class D1 extends C1{}

interface IA {}

class IAImpl implements IA{}