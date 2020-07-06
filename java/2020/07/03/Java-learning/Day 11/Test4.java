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
        List list = new ArrayList();//抑制黄警告
    }
    
}

class TestA{
    public void test(){

    }
}

class TestB extends TestA{//用于重写的注解
    @TestAnn(id=100,desc="name")//使用自定义的方法给属性作注解
    String name;

    @Override
    public void test() {
        // TODO Auto-generated method stub
        super.test();
    }

    @Deprecated
    public void test1(){//已过时

    }
}

@Target(ElementType.FIELD)//写明注解要用到什么地方,此处意为给类的属性做注解
@Retention(RetentionPolicy.RUNTIME)//定义注解的生命周期，此处意为整个程序的生命周期
@Documented//写入文档
@interface TestAnn{
    public int id() default 0;//注解不填时默认值为0

    public String desc() default "";
}