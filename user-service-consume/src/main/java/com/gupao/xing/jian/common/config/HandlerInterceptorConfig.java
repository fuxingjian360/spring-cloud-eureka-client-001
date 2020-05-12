package com.gupao.xing.jian.common.config;

import com.gupao.xing.jian.common.interceptor.MyHanderInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class HandlerInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    MyHanderInterceptor myHanderInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(myHanderInterceptor);
        interceptorRegistration.addPathPatterns("/**");
        //interceptorRegistration.excludePathPatterns("/userinfo/**");
    }
}
