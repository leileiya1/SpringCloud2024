package com.sapiece.service.impl;

import com.sapiece.mapper.StorageMapper;
import com.sapiece.service.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StorageServiceImpl implements StorageService {
    private final StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Long count) {
        log.info("------开始扣减库存-----");
        storageMapper.decrease(productId,count);
        log.info("------扣减库存结束-----");
    }
}
