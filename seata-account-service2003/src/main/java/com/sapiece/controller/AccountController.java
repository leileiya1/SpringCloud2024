package com.sapiece.controller;

import com.sapiece.resp.ResultData;
import com.sapiece.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    @PostMapping("/account/decrease")
    public ResultData decrease(@RequestParam("userId") Long userId,
                               @RequestParam("total")Long total){
        accountService.decrease(userId, total);
        return ResultData.success("账户余额扣减成功!");
    }
}
