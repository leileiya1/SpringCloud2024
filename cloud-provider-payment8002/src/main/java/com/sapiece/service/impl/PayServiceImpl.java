package com.sapiece.service.impl;

import com.sapiece.entities.Pay;
import com.sapiece.mapper.PayMapper;
import com.sapiece.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author SAPiece
 * @Create 2024-07-18 10:30
 * @Package com.sapiece.service.impl
 * @Project SpringCloud2024
 * @Filename PayServiceImpl
 * @Version 1.0
 */
@Service
@RequiredArgsConstructor
public class PayServiceImpl implements PayService {
    private final PayMapper payMapper;

    @Override
    public int add(Pay pay) {
        return payMapper.insert(pay);
    }

    @Override
    public int update(Pay pay) {
        return payMapper.updateByPrimaryKey(pay);
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteById(id);
    }

    @Override
    public Pay getById(Integer id) {
        return payMapper.selectById(id);
    }

    @Override
    public List<Pay> list() {
        return payMapper.selectList(null);
    }
}

