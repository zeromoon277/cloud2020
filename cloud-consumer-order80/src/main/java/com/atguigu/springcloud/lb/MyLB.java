package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-17 22:46
 */
@Component
public class MyLB implements LoadBlancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public final int getAndincrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0: current + 1;
        }while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("****next:" + next);
        return next;
    }


    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndincrement() % serviceInstances.size();

        return serviceInstances.get(index - 1);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("1");
        list.add("2");

        System.out.println(list.get(1));
    }
}
