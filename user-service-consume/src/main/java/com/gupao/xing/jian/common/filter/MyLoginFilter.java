package com.gupao.xing.jian.common.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/student/*",filterName = "myLoginFilter")
public class MyLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.err.println("MyLoginFilter.init(FilterConfig filterConfig)");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.err.println("MyLoginFilter.doFilter()==>before");
        filterChain.doFilter(servletRequest,servletResponse);
        System.err.println("MyLoginFilter.doFilter()==>after");
    }

    @Override
    public void destroy() {
        System.err.println("MyLoginFilter.destroy()");
    }
}
