package Day14pac;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import javax.naming.ldap.ManageReferralControl;

public class Test2 {
    public static void main(String[] args) {
        ItestDemo test = new TestDemoImpl();
        /**
         * 注意：如果一个对象想要通过Proxy.newProxyInstance方法被代理，
         *那么这个对象的类一定要有对应的接口，就像本例中的testDemo接口和实现类TestDemoImpl
         */
        test.test1();
        test.test2();
        System.out.println("===================================");
        
        /**
         * 需求：在执行test1和test2方法时要加入一些东西
         * 在执行方法前打印“test x start"
         * 在执行方法后打印“test x over”
         * 打印的方法名要和当时调用的方法保持一致
         */

        InvocationHandler handler = new ProxyDemo(test);
        /**
         * 下面的方法有三个参数
         * 参数一：代理对象的类加载器
         * 参数二：被代理的对象的接口
         * 参数三：代理对象
         * 
         * 返回的值是成功被代理后的对象.
         * 返回的是Object类型，需要依情况转换类型
         */
        ItestDemo t = (ItestDemo)Proxy.newProxyInstance(handler.getClass().getClassLoader(), test.getClass().getInterfaces(), handler);

        t.test1();
        System.out.println("=======================================================");
        t.test2();
    }
}