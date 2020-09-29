package com.zxq.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResultComment<T> {

    private  Integer code;
    private  String message;
    private  T data;
}
