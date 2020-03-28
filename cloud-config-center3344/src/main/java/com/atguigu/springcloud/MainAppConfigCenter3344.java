package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-26 22:35
 */
@SpringBootApplication
@EnableConfigServer

public class MainAppConfigCenter3344 {

    public static void main(String[] args) {

        SpringApplication.run(MainAppConfigCenter3344.class, args);
    }
}
