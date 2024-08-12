package com.sapiece.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sapiece.entities.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
* @author 周磊磊
* @description 针对表【t_account】的数据库操作Mapper
* @createDate 2024-08-11 16:42:54
* @Entity com.sapiece.entities.Account
*/
public interface AccountMapper extends BaseMapper<Account> {

    int deleteByPrimaryKey(Long id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
    @Update("update t_account set total=total-#{total},used=used+#{total},residue=residue-#{total} where user_id=#{userId}")
    void decrease(@Param("userId") Long userId,@Param("total") Long total);

}
