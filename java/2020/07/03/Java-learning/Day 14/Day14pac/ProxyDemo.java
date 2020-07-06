package Day14pac;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ��̬������
 */

public class ProxyDemo implements InvocationHandler {

    Object obj;//������Ķ���

    public ProxyDemo(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub

        System.out.println(method.getName() + " start");

        Object result = method.invoke(this.obj, args);//ִ�е���ָ����������ָ������

        System.out.println(method.getName() + " start");

        return result;
    }
    
}