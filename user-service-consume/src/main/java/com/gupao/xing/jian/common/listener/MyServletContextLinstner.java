package com.gupao.xing.jian.common.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextLinstner implements ServletContextListener {

    Logger logger = LoggerFactory.getLogger(MyHttpSessionListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.error("MyServletContextLinstner.contextInitialized(ServletContextEvent sce)=>{}", "调用");
        System.err.println("MyServletContextLinstner.contextInitialized(ServletContextEvent sce)=>{调用}");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("MyServletContextLinstner.contextDestroyed(ServletContextEvent sce)=>{}", "调用");
        System.err.println("MyServletContextLinstner.contextDestroyed(ServletContextEvent sce)=>{调用}");
    }

}
