package com.sapiece.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_storage
 */
@TableName(value ="t_storage")
@Data
public class Storage implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long productId;

    /**
     * 
     */
    private Long total;

    /**
     * 
     */
    private Integer used;

    /**
     * 
     */
    private Integer residue;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}