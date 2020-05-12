package com.gupao.xing.jian.common.filter;


import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class MySourceFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        httpServletRequest.setAttribute("nameatt", "valueatt");

        Map<String, Object> headMaps = new HashMap<String, Object>();
        Enumeration<String> headNames = httpServletRequest.getHeaderNames();
        while (headNames.hasMoreElements()) {
            String name = headNames.nextElement();
            headMaps.put(headNames.nextElement(), httpServletRequest.getHeader(name));
        }

        Cookie[] cookies = httpServletRequest.getCookies();

        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("sessionname001","sessionvalue001");
        System.err.println("MySourceFilter.doFilter()==>before");
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        for (int i = 1; i < 10; i++) {
            response.addHeader("header00" + i, "value00" + i);
        }
        Cookie cookie = new Cookie("cookie001", "value001");
        cookie.setPath("/cookie/uri");
        response.addCookie(cookie);

        filterChain.doFilter(servletRequest, servletResponse);
        System.err.println("MySourceFilter.doFilter()==>after");

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.err.println("MySourceFilter.init(FilterConfig filterConfig)");
    }

    @Override
    public void destroy() {
        System.err.println("MySourceFilter.destroy()");
    }
}
