package com.gupao.xing.jian.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;


@Service
public class TestAutoBean4 implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {


    public TestAutoBean4() {
        System.out.println("TestAutoBean4()");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("TestAutoBean4-BeanNameAware.setBeanName(String s)");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("TestAutoBean4-BeanFactoryAware.setBeanFactory(BeanFactory beanFactory)");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("TestAutoBean4-ApplicationContextAware.setApplicationContext(ApplicationContext applicationContext)");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("TestAutoBean4-InitializingBean.afterPropertiesSet()");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("TestAutoBean4-DisposableBean.destroy()");
    }
}
