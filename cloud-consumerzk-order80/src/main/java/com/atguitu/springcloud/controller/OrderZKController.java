package com.atguitu.springcloud.controller;

import com.atguigu.springcloud.domain.PayMent;
import com.atguigu.springcloud.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-14 15:30
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/payment")
@Slf4j
public class OrderZKController {

    @Value("${server.port}")
    private String serverPort;

    private static final String INVOKE_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/zk")
    public String paymentinfo(){
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);

    }
}
