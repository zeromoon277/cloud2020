package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.domain.PayMent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-14 15:18
 */
public interface PayMendRespository extends JpaRepository<PayMent, String> {
}
