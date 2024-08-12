package com.sapiece.service;

import org.apache.ibatis.annotations.Param;

public interface StorageService {
    void decrease( Long productId, Long count);
}
