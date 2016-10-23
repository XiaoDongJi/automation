package com.citichma.mapper;

import com.citichma.pojo.TimeNode;
import com.citichma.pojo.TimeNodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TimeNodeMapper {
    int countByExample(TimeNodeExample example);

    int deleteByExample(TimeNodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TimeNode record);

    int insertSelective(TimeNode record);

    List<TimeNode> selectByExample(TimeNodeExample example);

    TimeNode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TimeNode record, @Param("example") TimeNodeExample example);

    int updateByExample(@Param("record") TimeNode record, @Param("example") TimeNodeExample example);

    int updateByPrimaryKeySelective(TimeNode record);

    int updateByPrimaryKey(TimeNode record);
}