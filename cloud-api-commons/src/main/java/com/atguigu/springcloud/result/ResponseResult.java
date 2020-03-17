package com.atguigu.springcloud.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-03-14 15:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> implements Serializable {

    private int code;
    private String note;
    private T t;

    public ResponseResult(int code, String note) {
        this.code = code;
        this.note = note;
    }
}
