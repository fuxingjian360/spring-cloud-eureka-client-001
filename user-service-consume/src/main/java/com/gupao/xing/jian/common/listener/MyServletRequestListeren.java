package com.gupao.xing.jian.common.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListeren implements ServletRequestListener {

    Logger logger = LoggerFactory.getLogger(MyServletRequestListeren.class);

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.error("requestDestroyed(ServletRequestEvent sre)=>{}", "调用");
        System.err.println("requestDestroyed(ServletRequestEvent sre)=>{调用}");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        logger.error("requestInitialized(ServletRequestEvent sre)=>{}", "调用");
        System.err.println("requestInitialized(ServletRequestEvent sre)=>{调用}");
    }
}
