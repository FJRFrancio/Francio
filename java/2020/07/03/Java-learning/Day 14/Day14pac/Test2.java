package Day14pac;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import javax.naming.ldap.ManageReferralControl;

public class Test2 {
    public static void main(String[] args) {
        ItestDemo test = new TestDemoImpl();
        /**
         * ע�⣺���һ��������Ҫͨ��Proxy.newProxyInstance����������
         *��ô����������һ��Ҫ�ж�Ӧ�Ľӿڣ��������е�testDemo�ӿں�ʵ����TestDemoImpl
         */
        test.test1();
        test.test2();
        System.out.println("===================================");
        
        /**
         * ������ִ��test1��test2����ʱҪ����һЩ����
         * ��ִ�з���ǰ��ӡ��test x start"
         * ��ִ�з������ӡ��test x over��
         * ��ӡ�ķ�����Ҫ�͵�ʱ���õķ�������һ��
         */

        InvocationHandler handler = new ProxyDemo(test);
        /**
         * ����ķ�������������
         * ����һ�����������������
         * ��������������Ķ���Ľӿ�
         * ���������������
         * 
         * ���ص�ֵ�ǳɹ��������Ķ���.
         * ���ص���Object���ͣ���Ҫ�����ת������
         */
        ItestDemo t = (ItestDemo)Proxy.newProxyInstance(handler.getClass().getClassLoader(), test.getClass().getInterfaces(), handler);

        t.test1();
        System.out.println("=======================================================");
        t.test2();
    }
}