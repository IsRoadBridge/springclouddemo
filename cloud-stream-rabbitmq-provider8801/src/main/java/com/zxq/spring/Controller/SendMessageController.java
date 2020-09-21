package com.zxq.spring.Controller;


import com.zxq.spring.service.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    @Autowired
    private MessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public  String send(){
        return messageProvider.send();
    }
}
