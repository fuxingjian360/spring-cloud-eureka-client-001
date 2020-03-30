package com.gupao.xing.jian.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;


@Service
public class TestAutoBean3 implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public TestAutoBean3() {
        System.out.println("TestAutoBean3()");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("TestAutoBean3-BeanNameAware.setBeanName(String s)");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("TestAutoBean3-BeanFactoryAware.setBeanFactory(BeanFactory beanFactory)");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("TestAutoBean3-ApplicationContextAware.setApplicationContext(ApplicationContext applicationContext)");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.setName("haha---->");
        System.out.println("TestAutoBean3-InitializingBean.afterPropertiesSet()");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("TestAutoBean3-DisposableBean.destroy()");
    }
}
