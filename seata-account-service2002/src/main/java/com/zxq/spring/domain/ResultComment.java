package com.zxq.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultComment<T> {
    private  Integer code;
    private  String message;
    private  T  data;

}
