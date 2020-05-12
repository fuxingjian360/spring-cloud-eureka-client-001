package com.gupao.xing.jian;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
        import springfox.documentation.swagger2.annotations.EnableSwagger2;

        import java.util.concurrent.ScheduledThreadPoolExecutor;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class UserServiceProviderBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceProviderBootstrap.class, args);
    }

}
