package com.gupao.xing.jian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.gupao.xing.jian.app1.**.mapper", sqlSessionTemplateRef = "db1SqlSessionTemplate")
@MapperScan(basePackages = "com.gupao.xing.jian.app2.**.mapper", sqlSessionTemplateRef = "db2SqlSessionTemplate")
@EnableTransactionManagement
@EnableFeignClients
@EnableHystrix
public class UserServiceConsumeBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceConsumeBootstrap.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
