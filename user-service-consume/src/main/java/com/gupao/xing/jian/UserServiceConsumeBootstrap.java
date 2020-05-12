package com.gupao.xing.jian;

import com.gupao.xing.jian.app1.userinfo.domain.UserInfo;
import com.gupao.xing.jian.app1.userinfo.service.impl.UserInfoServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.gupao.xing.jian.app1.**.mapper", sqlSessionTemplateRef = "db1SqlSessionTemplate")
@MapperScan(basePackages = "com.gupao.xing.jian.app2.**.mapper", sqlSessionTemplateRef = "db2SqlSessionTemplate")
@EnableTransactionManagement
@ServletComponentScan
@EnableFeignClients
@EnableHystrix
public class UserServiceConsumeBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UserServiceConsumeBootstrap.class, args);
//        UserInfoServiceImpl userInfoServiceImpl = (UserInfoServiceImpl)context.getBean("userInfoServiceImpl");
//        try {
//            int  user = userInfoServiceImpl.addUserInfo(new UserInfo());
//            System.err.println(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
