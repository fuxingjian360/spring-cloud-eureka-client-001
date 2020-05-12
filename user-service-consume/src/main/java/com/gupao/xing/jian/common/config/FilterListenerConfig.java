package com.gupao.xing.jian.common.config;

import com.gupao.xing.jian.common.filter.MySourceFilter;
import com.gupao.xing.jian.common.listener.MyServletRequestListeren;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class FilterListenerConfig {
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean listenerRegistBean = new ServletListenerRegistrationBean();
        listenerRegistBean.setListener(new MyServletRequestListeren());
        return listenerRegistBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MySourceFilter());
        filterRegistrationBean.addInitParameter("exclusions","/student/getStudentsAndUserInfo");
        Set<String> path = new HashSet<String>();
        path.add("/*");
        filterRegistrationBean.setUrlPatterns(path);
        filterRegistrationBean.setName("mySourceFilter");
        filterRegistrationBean.setOrder(10);
        return filterRegistrationBean;
    }
}
