package com.atguitu.springcloud.service;

import com.atguigu.springcloud.domain.PayMent;
import com.atguigu.springcloud.result.ResponseResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-18 23:21
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE")
public interface PaymentFeignService {


    @GetMapping(value = "/payment/hystrix/ok")
    String getOk(@RequestParam(value = "id") Integer id);

    @GetMapping(value = "/payment/hystrix/fail")
    String getFAIL(@RequestParam(value = "id") Integer id);


}
