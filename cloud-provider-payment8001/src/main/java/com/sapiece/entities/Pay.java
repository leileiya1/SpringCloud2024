package com.sapiece.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @TableName t_pay
 */
@TableName(value = "t_pay")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "支付表")
public class Pay implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键id")
    private Integer id;

    /**
     * 支付流水号
     */
    @Schema(description = "支付流水号")
    private String payNo;

    /**
     * 订单流水号
     */
    @Schema(description = "订单流水号")
    private String orderNo;

    /**
     *
     */
    @Schema(description = "用户id")
    private Integer userId;

    /**
     *
     */
    @Schema(description = "余额")
    private BigDecimal amount;

    /**
     *
     */
    @Schema(description = "是否删除")
    private Integer deleted;

    /**
     *
     */
    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     *
     */
    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}