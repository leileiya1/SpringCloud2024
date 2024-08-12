package com.sapiece.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sapiece.entities.Pay;

/**
* @author 周磊磊
* @description 针对表【t_pay】的数据库操作Mapper
* @createDate 2024-07-18 09:19:29
* @Entity com.sapiece.entities.Pay
*/
public interface PayMapper extends BaseMapper<Pay> {

    int deleteByPrimaryKey(Long id);

    int insert(Pay record);


    int insertSelective(Pay record);

    Pay selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Pay record);

    int updateByPrimaryKey(Pay record);

}
