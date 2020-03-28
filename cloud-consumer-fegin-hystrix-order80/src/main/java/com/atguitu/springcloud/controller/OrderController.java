package com.atguitu.springcloud.controller;


import com.atguigu.springcloud.domain.PayMent;
import com.atguigu.springcloud.result.ResponseResult;
import com.atguitu.springcloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-14 21:18
 */
@RestController
@DefaultProperties(defaultFallback = "failGlobalHandler")
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/hystrix/ok")
    public String ok(@RequestParam(value = "id") Integer id) {
        return paymentFeignService.getOk(id);
    }

    @GetMapping("/consumer/payment/hystrix/fail")
//    @HystrixCommand(fallbackMethod = "failHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
//    })
    @HystrixCommand
    public String fail(@RequestParam(value = "id") Integer id) {
        return paymentFeignService.getFAIL(id);
    }

    public String failHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + id + "消费者业务繁忙请稍后。。。。。";
    }

    public String failGlobalHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + id + "全局消费者业务繁忙请稍后。。。。。";
    }
}
