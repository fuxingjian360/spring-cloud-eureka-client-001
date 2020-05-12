package com.gupao.xing.jian.common.interceptor;

import com.gupao.xing.jian.common.util.MyRedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyHanderInterceptor implements HandlerInterceptor {

    @Autowired
    private MyRedisTemplate myRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.err.println("MyHanderInterceptor.preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)==>调用");
        response.addHeader("MyHanderInterceptorH001", "value100");
        response.addHeader("MyHanderInterceptorH002", "value110");
        response.addHeader("MyHanderInterceptorH002", "value110");
        response.addHeader("MyHanderInterceptorH002", "value110");
        Cookie cookie = new Cookie("MyHanderInterceptorC001", "MyHanderInterceptorC001");
        Cookie cookie2 = new Cookie("MyHanderInterceptorC001", "MyHanderInterceptorC001");
        Cookie cookie3 = new Cookie("MyHanderInterceptorC001", "MyHanderInterceptorC001");
        cookie.setPath("/MyHanderInterceptor/path");
        response.addCookie(cookie);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        myRedisTemplate.set("mykey001","myvalu001",3);
        myRedisTemplate.set("mykey002","myvalu002",3);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.err.println("MyHanderInterceptor.postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) ==>调用");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.err.println("MyHanderInterceptor.afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) ==>调用");
    }
}
