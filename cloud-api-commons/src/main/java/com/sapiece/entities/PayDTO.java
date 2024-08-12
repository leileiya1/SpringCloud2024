package com.sapiece.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author SAPiece
 * @Create 2024-07-18 9:21
 * @Package com.sapiece.entities
 * @Project SpringCloud2024
 * @Filename PayDTO
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayDTO implements Serializable {
    private Integer id;

    /**
     * 支付流水号
     */
    private String payNo;

    /**
     * 订单流水号
     */
    private String orderNo;

    /**
     *用户id
     */
    private Integer userId;

    /**
     *余额
     */
    private BigDecimal amount;
}
