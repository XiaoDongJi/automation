package com.citichma.mapper;

import com.citichma.pojo.FileUpload;
import com.citichma.pojo.FileUploadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileUploadMapper {
    int countByExample(FileUploadExample example);

    int deleteByExample(FileUploadExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FileUpload record);

    int insertSelective(FileUpload record);

    List<FileUpload> selectByExample(FileUploadExample example);

    FileUpload selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FileUpload record, @Param("example") FileUploadExample example);

    int updateByExample(@Param("record") FileUpload record, @Param("example") FileUploadExample example);

    int updateByPrimaryKeySelective(FileUpload record);

    int updateByPrimaryKey(FileUpload record);
}