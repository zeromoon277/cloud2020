package com.atguitu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-21 22:16
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderFeginHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeginHystrixMain80.class, args);
    }
}
