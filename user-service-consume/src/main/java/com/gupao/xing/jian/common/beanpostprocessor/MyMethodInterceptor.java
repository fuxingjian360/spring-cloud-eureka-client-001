package com.gupao.xing.jian.common.beanpostprocessor;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.err.println("调用前。。。");
        Object result = methodProxy.invokeSuper(o,objects);
        System.err.println("调用后。。。");
        return result;
    }
}
