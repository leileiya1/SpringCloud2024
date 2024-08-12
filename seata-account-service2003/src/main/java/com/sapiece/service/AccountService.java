package com.sapiece.service;

import org.apache.ibatis.annotations.Param;

public interface AccountService {
    void decrease(Long userId,Long total);
}
