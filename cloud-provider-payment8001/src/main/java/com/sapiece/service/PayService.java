package com.sapiece.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sapiece.entities.Pay;

import java.util.List;

/**
 * @Author SAPiece
 * @Create 2024-07-18 10:29
 * @Package com.sapiece.service
 * @Project SpringCloud2024
 * @Filename PayService
 * @Version 1.0
 */

public interface PayService{
    int add(Pay pay);
    int update(Pay pay);
    int delete(Integer id);
    Pay getById(Integer id);
    List<Pay> list();
}
