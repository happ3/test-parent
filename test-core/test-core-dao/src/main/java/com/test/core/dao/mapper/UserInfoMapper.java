package com.test.core.dao.mapper;

import com.test.base.repository.UserInfo;
import com.test.base.repository.UserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserInfoMapper {
    int countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    @Select(value="SELECT * FROM user_info d WHERE d.id = #{id}")
	UserInfo getUserInfoById(Integer id);
    
    @Select(value="SELECT * FROM user_info d WHERE d.state= #{state}")
    List<UserInfo> findByState(Integer state);
    
}