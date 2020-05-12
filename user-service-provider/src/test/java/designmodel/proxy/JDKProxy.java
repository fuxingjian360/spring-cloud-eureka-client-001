package designmodel.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKProxy implements InvocationHandler {

    Object target;

    public JDKProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("invoke,前");
        Class<?>[] clazzs = method.getParameterTypes();
        Object ob1 = method.invoke(target, args);
        System.err.println("invoke,后");
        return ob1;
    }
}
