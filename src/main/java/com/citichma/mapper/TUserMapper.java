package com.citichma.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.citichma.common.vo.UserInfoVo;
import com.citichma.pojo.TUser;
import com.citichma.pojo.TUserExample;

public interface TUserMapper {
    int countByExample(TUserExample example);

    int deleteByExample(TUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(TUser record);

    int insertSelective(TUser record);

    List<TUser> selectByExample(TUserExample example);

    TUser selectByPrimaryKey(Integer userId);
    
    TUser selectByUserNo(String userNo);
    
    UserInfoVo findUserVoByUid(Integer userId);

    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}