package com.zxq.spring.controller;

import com.zxq.spring.domain.ResultComment;
import com.zxq.spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/account/deCreate")
    public ResultComment deCreate(@RequestParam("userId") Long userId,
                                  @RequestParam("money") BigDecimal money){
        accountService.deCreate(userId,money);
        return  new ResultComment(200,"扣减余额成功",null);
    }
}
