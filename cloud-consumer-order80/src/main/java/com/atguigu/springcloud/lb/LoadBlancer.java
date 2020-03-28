package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-17 22:43
 */
public interface LoadBlancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
