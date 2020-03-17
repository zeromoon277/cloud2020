package com.atguigu.springcloud.controller;

import cn.hutool.core.date.DateUtil;
import com.atguigu.springcloud.domain.PayMent;
import com.atguigu.springcloud.result.ResponseResult;
import com.atguigu.springcloud.service.IPayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-14 15:30
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/payment")
@Slf4j
public class PayMentController {

    @Autowired
    private IPayMentService payMentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/save")
    public ResponseResult<PayMent> save(){
        PayMent payMent = new PayMent();
        payMent.setOrderNo(DateUtil.now());
        payMent.setUsername("yyc");
        payMentService.addPayMent(payMent);
        ResponseResult<PayMent> result = new ResponseResult<PayMent>(200, "成功", payMent);
        log.info("插入成功" + serverPort);
        return result;


    }
}
