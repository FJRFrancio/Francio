package Day14pac;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类
 */

public class ProxyDemo implements InvocationHandler {

    Object obj;//被代理的对象

    public ProxyDemo(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub

        System.out.println(method.getName() + " start");

        Object result = method.invoke(this.obj, args);//执行的是指定代理对象的指定方法

        System.out.println(method.getName() + " start");

        return result;
    }
    
}