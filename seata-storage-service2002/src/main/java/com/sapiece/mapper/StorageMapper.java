package com.sapiece.mapper;

import com.sapiece.entities.Storage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author 周磊磊
 * @description 针对表【t_storage】的数据库操作Mapper
 * @createDate 2024-08-11 16:46:28
 * @Entity com.sapiece.entities.Storage
 */
public interface StorageMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);

    @Update("update t_storage set used=used+#{count},residue=residue-#{count} where product_id=#{productId}")
    void decrease(@Param("productId") Long productId, @Param("count") Long count);
}
