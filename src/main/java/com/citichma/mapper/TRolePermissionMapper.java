package com.citichma.mapper;

import com.citichma.pojo.TRolePermission;
import com.citichma.pojo.TRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRolePermissionMapper {
    int countByExample(TRolePermissionExample example);

    int deleteByExample(TRolePermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TRolePermission record);

    int insertSelective(TRolePermission record);

    List<TRolePermission> selectByExample(TRolePermissionExample example);

    TRolePermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TRolePermission record, @Param("example") TRolePermissionExample example);

    int updateByExample(@Param("record") TRolePermission record, @Param("example") TRolePermissionExample example);

    int updateByRoleIdSelective(TRolePermission record);

    int updateByPrimaryKey(TRolePermission record);
    
    
}