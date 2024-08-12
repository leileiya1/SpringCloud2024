package com.sapiece.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName t_account
 */
@TableName(value ="t_account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private BigDecimal total;

    /**
     * 
     */
    private BigDecimal used;

    /**
     * 
     */
    private BigDecimal residue;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}