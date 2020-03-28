package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.domain.PayMent;
import com.atguigu.springcloud.lb.LoadBlancer;
import com.atguigu.springcloud.result.ResponseResult;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-14 21:18
 */
@RestController
public class OrderController {
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBlancer loadBlancer;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public ResponseResult create(PayMent payMent) {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() == 0){
            return new ResponseResult();
        }

        ServiceInstance serviceInstance = loadBlancer.instances(instances);

        return restTemplate.postForObject(serviceInstance.getUri() + "/payment/save", payMent, ResponseResult.class);
//        return restTemplate.postForObject(PAYMENT_URL + "/payment/save", payMent, ResponseResult.class);
    }
}
