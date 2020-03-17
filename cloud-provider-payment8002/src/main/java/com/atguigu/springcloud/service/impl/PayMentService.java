package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PayMendRespository;
import com.atguigu.springcloud.domain.PayMent;
import com.atguigu.springcloud.service.IPayMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
