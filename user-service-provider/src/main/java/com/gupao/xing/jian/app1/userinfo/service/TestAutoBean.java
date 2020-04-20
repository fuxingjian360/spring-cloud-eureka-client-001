package com.gupao.xing.jian.app1.userinfo.service;

import com.gupao.xing.jian.app1.userinfo.controller.TestAutoBean3;
import com.gupao.xing.jian.app1.userinfo.controller.TestAutoBean4;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;


@Service
public class TestAutoBean implements  BeanPostProcessor {


    public TestAutoBean() {
        System.out.println("TestAutoBean()");
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof TestAutoBean3){
            System.out.println("TestAutoBean3-BeanPostProcessor.postProcessBeforeInitialization(Object bean, String beanName)");
        }
        if(bean instanceof TestAutoBean4){
            System.out.println("TestAutoBean4-BeanPostProcessor.postProcessBeforeInitialization(Object bean, String beanName)");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof TestAutoBean3) {
            System.out.println("TestAutoBean3-BeanPostProcessor.postProcessAfterInitialization(Object bean, String beanName)");
        }

        if(bean instanceof TestAutoBean4) {
            System.out.println("TestAutoBean4-BeanPostProcessor.postProcessAfterInitialization(Object bean, String beanName)");
        }
        return bean;
    }


}
