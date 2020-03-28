package com.atguigu.springcloud;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-28 20:14
 */
@Component
@EnableBinding(Sink.class)
public class MessageReveiceController {


   @StreamListener(Sink.INPUT)
   public void input(Message<String> message){

       System.out.println(123);
       System.out.println(message.getPayload());
   }
}
