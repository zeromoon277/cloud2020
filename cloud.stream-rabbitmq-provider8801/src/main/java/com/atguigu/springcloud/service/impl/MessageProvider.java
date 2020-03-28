package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-28 20:07
 */
@EnableBinding(Source.class)  //定义消息的推送管道
public class MessageProvider implements IMessageProvider {
    @Resource
    private MessageChannel output;


    public String send() {
        boolean res = output.send(MessageBuilder.withPayload("stream message send").build());
        System.out.println("*****serial" + res);
        return null;

    }
}
