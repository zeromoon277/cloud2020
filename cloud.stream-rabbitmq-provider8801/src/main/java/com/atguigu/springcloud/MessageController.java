package com.atguigu.springcloud;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-28 20:14
 */
@RestController
public class MessageController {
    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/send")
    public String sendMessage(){
        return messageProvider.send();
    }
}
