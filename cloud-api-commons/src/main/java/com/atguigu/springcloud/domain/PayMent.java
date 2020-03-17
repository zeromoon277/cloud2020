package com.atguigu.springcloud.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-14 15:20
 */

@Entity
@Table(name = "c_payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayMent {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "username", unique = true, nullable = false, length = 64)
    private String username;

    @Column(name = "password", nullable = false, length = 64)
    private String orderNo;

}
