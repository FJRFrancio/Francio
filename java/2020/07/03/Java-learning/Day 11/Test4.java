import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        new TestB().test1();
        @SuppressWarnings("rawtypes")
        List list = new ArrayList();//���ƻƾ���
    }
    
}

class TestA{
    public void test(){

    }
}

class TestB extends TestA{//������д��ע��
    @TestAnn(id=100,desc="name")//ʹ���Զ���ķ�����������ע��
    String name;

    @Override
    public void test() {
        // TODO Auto-generated method stub
        super.test();
    }

    @Deprecated
    public void test1(){//�ѹ�ʱ

    }
}

@Target(ElementType.FIELD)//д��ע��Ҫ�õ�ʲô�ط�,�˴���Ϊ�����������ע��
@Retention(RetentionPolicy.RUNTIME)//����ע����������ڣ��˴���Ϊ�����������������
@Documented//д���ĵ�
@interface TestAnn{
    public int id() default 0;//ע�ⲻ��ʱĬ��ֵΪ0

    public String desc() default "";
}