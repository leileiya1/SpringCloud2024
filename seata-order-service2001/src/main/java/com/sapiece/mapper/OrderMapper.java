package com.sapiece.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sapiece.entities.Order;

/**
* @author 周磊磊
* @description 针对表【t_order】的数据库操作Mapper
* @createDate 2024-08-11 15:57:10
* @Entity com.sapiece.entities.Order
*/
public interface OrderMapper extends BaseMapper<Order> {

    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

}
