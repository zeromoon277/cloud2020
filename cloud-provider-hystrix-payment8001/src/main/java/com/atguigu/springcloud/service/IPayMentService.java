package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.PayMent;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-14 15:28
 */
public interface IPayMentService {

    boolean addPayMent(PayMent payMent);

    public String paymentInfo_ok(Integer id);

    public String paymentInfo_fail(Integer id);

    public String paymentCircuitBreaker(Integer id);
}
