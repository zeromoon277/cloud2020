package com.atguitu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-22 23:25
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9527 {
    public static void main(String[] args) {

        SpringApplication.run(GateWayMain9527.class, args);
    }
}
