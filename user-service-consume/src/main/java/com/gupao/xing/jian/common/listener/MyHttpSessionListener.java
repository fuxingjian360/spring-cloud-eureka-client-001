package com.gupao.xing.jian.common.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    Logger logger = LoggerFactory.getLogger(MyHttpSessionListener.class);
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.error("MyHttpSessionListener.sessionCreated(HttpSessionEvent se)=>{}","调用");
        System.err.println("MyHttpSessionListener.sessionCreated(HttpSessionEvent se)=>{调用}");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.error("MyHttpSessionListener.sessionDestroyed(HttpSessionEvent se)=>{}","调用");
        System.err.println("MyHttpSessionListener.sessionDestroyed(HttpSessionEvent se)=>{调用}");
    }
}
