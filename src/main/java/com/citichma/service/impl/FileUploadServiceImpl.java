package com.citichma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citichma.mapper.FileUploadMapper;
import com.citichma.pojo.FileUpload;
import com.citichma.service.FileUploadService;

/**
 * 
 * 文件上传接口实现
 * @author JIXD 
 * @date 2016年8月7日 下午12:52:30  
 *
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {
	@Autowired
	private FileUploadMapper fileMapper;
	@Override
	public int saveFileUpload(FileUpload fileUpload) {
		return fileMapper.insertSelective(fileUpload);
	}
	
	@Override
	public int delFile(Integer id) {
		return fileMapper.deleteByPrimaryKey(id);
	}

	@Override
	public FileUpload findFileById(Integer id) {
		return fileMapper.selectByPrimaryKey(id);
	}

}
