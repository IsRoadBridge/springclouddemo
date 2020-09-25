package com.zxq.spring.contorller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zxq.spring.myhandler.MyBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController {

    @GetMapping("/testA")
    public  String testA(){
        return  "=======testA";
    }

    @GetMapping("/testB")
    public  String testB(){
        return  "=======testB";
    }

    @GetMapping("/testC")
    public  String testC(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  "=======testC RT测试";
    }

    @GetMapping("/testD")
    public  String testD(){
        int i =10/0;
        return  "=======testD 异常比例测试";
    }

    @GetMapping("/testE")
    public  String testE(){
        int i =10/0;
        return  "=======testE 异常数测试";
    }

    @GetMapping("/hotKey")
    @SentinelResource(value = "hotKey",blockHandler = "bad_hotKey")
    public  String hotKey(@RequestParam(value = "p1",required = false) String p1,
                          @RequestParam(value = "p2",required = false) String p2){

        return  "=======hotKey";
    }



    @GetMapping("/myself")
    @SentinelResource(value = "myself",blockHandlerClass = MyBlockHandler.class,blockHandler = "handlerException")
    public  String mySelf(){

        return  "=======自定义异常处理类正确方法";
    }


    @GetMapping("/handler")
    @SentinelResource(value = "handler",blockHandlerClass = MyBlockHandler.class,blockHandler = "handlerException2")
    public  String hotKey(@RequestParam(value = "p1",required = false) String p1){

        return  "=======带参的自定义handler";
    }


}
