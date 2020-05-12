package com.gupao.xing.jian.common.beanpostprocessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("MyInvocationHandler========目标方法调用前===》");
        Object object = method.invoke(target,args);
        System.err.println("MyInvocationHandler========目标方法调用后===》");
        return object;
    }
}
