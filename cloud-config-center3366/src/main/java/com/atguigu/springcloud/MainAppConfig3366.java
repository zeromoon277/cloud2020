package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-28 17:15
 */
@SpringBootApplication
@EnableEurekaClient
public class MainAppConfig3366 {

    public static void main(String[] args) {
        SpringApplication.run(MainAppConfig3366.class, args);
    }
}
