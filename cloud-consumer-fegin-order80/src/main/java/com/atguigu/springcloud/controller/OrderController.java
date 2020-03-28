package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.domain.PayMent;
import com.atguigu.springcloud.result.ResponseResult;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-14 21:18
 */
@RestController
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/create")
    public ResponseResult create(PayMent payMent) {
        ResponseResult<PayMent> payMentResponseResult = paymentFeignService.create();
        return payMentResponseResult;
    }
}
