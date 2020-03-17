package com.atguigu.springcloud.controller;

import cn.hutool.core.date.DateUtil;
import com.atguigu.springcloud.domain.PayMent;
import com.atguigu.springcloud.result.ResponseResult;
import com.atguigu.springcloud.service.IPayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-14 15:30
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/payment")
@Slf4j
public class PayMentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/zk")
    public String findzk(){

        return "springcloud with zookeeper: "+ serverPort + "  " + UUID.randomUUID().toString();


    }
}
