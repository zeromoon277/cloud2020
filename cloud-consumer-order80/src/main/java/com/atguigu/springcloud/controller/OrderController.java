package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.domain.PayMent;
import com.atguigu.springcloud.result.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-14 21:18
 */
@RestController
public class OrderController {
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";


    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public ResponseResult create(PayMent payMent) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save", payMent, ResponseResult.class);
    }
}
