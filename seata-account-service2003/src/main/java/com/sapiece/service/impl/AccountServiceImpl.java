package com.sapiece.service.impl;

import com.sapiece.mapper.AccountMapper;
import com.sapiece.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountMapper accountMapper;
    @Override
    public void decrease(Long userId, Long total) {
        log.info("账户扣减：user_id={}, money={}", userId, total);
        accountMapper.decrease(userId, total);
       //myTimeOut();  // 模拟执行时间
        //int time=10/0;
        log.info("扣减完成");
    }
    private static void myTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(65);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
