package com.citichma.service;

import com.citichma.pojo.FileUpload;

/**
 * 
 * 图片上传服务接口
 * @author JIXD 
 * @date 2016年8月7日 上午10:58:11  
 *
 */
public interface FileUploadService {
	/**
	 * 
	 * 上传文件保存 
	 * @param   
	 * @return 
	 * @date 2016年8月7日 下午12:50:44  
	 * @throws
	 */
	int saveFileUpload(FileUpload fileUpload);
	
	/**
	 * 
	 * 删除文件 
	 * @param   
	 * @return 
	 * @date 2016年8月14日 下午6:35:13  
	 * @throws
	 */
	int delFile(Integer id);
	
	/**
	 * 
	 * 根据id查询上传文件 
	 * @param   
	 * @return 
	 * @date 2016年8月14日 下午6:37:58  
	 * @throws
	 */
	FileUpload findFileById(Integer id);
	
}
