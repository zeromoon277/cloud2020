package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.PayMent;
import com.atguigu.springcloud.result.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-18 23:21
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @PostMapping(value = "/payment/save")
    ResponseResult<PayMent> create();

}
