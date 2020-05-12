package com.gupao.xing.jian.common.beanpostprocessor;

import net.sf.cglib.proxy.Enhancer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.err.println("MyBeanPostProcessor.postProcessBeforeInitialization==>");
//        if ("userInfoServiceImpl".equals(beanName)) {
//            Enhancer enhancer = new Enhancer();
//            enhancer.setCallback(new MyMethodInterceptor());
//            enhancer.setSuperclass(bean.getClass());
//            return enhancer.create();
//        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        if ("userInfoServiceImpl".equals(beanName)) {
//            Enhancer enhancer = new Enhancer();
//            enhancer.setCallback(new MyMethodInterceptor());
//            enhancer.setSuperclass(bean.getClass());
//            return enhancer.create();
////            Class[] interfaces = bean.getClass().getInterfaces();
////            if(interfaces!=null && interfaces.length>0){
////                MyInvocationHandler myInvocationHandler = new MyInvocationHandler(bean);
////                Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), interfaces, myInvocationHandler);
////                return proxy;
////            }
//        }
        return bean;
    }
}
