package com.atguitu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-25 22:45
 */
@Configuration
public class GateWay {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("route1", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
    }

}
