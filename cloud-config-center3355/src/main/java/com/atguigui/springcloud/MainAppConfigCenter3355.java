package com.atguigui.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-26 22:51
 */
@SpringBootApplication
@EnableEurekaClient
public class MainAppConfigCenter3355 {
    public static void main(String[] args) {
        SpringApplication.run(MainAppConfigCenter3355.class, args);
    }
}
