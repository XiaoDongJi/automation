package com.citichma.mapper;

import com.citichma.pojo.TMenuInfo;
import com.citichma.pojo.TMenuInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMenuInfoMapper {
    int countByExample(TMenuInfoExample example);

    int deleteByExample(TMenuInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TMenuInfo record);

    int insertSelective(TMenuInfo record);

    List<TMenuInfo> selectByExample(TMenuInfoExample example);

    TMenuInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TMenuInfo record, @Param("example") TMenuInfoExample example);

    int updateByExample(@Param("record") TMenuInfo record, @Param("example") TMenuInfoExample example);

    int updateByPrimaryKeySelective(TMenuInfo record);

    int updateByPrimaryKey(TMenuInfo record);
}