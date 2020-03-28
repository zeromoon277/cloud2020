package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.dao.PayMendRespository;
import com.atguigu.springcloud.domain.PayMent;
import com.atguigu.springcloud.service.IPayMentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-14 15:29
 */
@Service
public class PayMentService implements IPayMentService {
    @Autowired
    private PayMendRespository payMendRespository;

    public boolean addPayMent(PayMent payMent) {
        PayMent save = payMendRespository.save(payMent);
        return false;
    }

    public String paymentInfo_ok(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + id + "^_^";
    }


    @HystrixCommand(fallbackMethod = "failHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_fail(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + id + "超时。。。。。";
    }

    public String failHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + id + "业务繁忙请稍后。。。。。";
    }


    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_failHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuitBreaker(Integer id) {
        if(id < 0){
            throw new RuntimeException("*****id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return "线程池:" + Thread.currentThread().getName() + id + "++流水号" + serialNumber;
    }
    public String paymentCircuitBreaker_failHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + id + "id不能为负数。。。。。";
    }


}
