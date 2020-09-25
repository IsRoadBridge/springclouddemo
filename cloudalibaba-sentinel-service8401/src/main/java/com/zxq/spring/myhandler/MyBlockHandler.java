package com.zxq.spring.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class MyBlockHandler {

    public  static  String handlerException(BlockException exception){
        return  "自定义的全局兜底方法";
    }

    public  static  String handlerException2(String p1,BlockException exception){
        return  "自定义的全局带参兜底方法";
    }
}
