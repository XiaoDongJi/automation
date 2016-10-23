package com.citichma.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.citichma.common.constant.MessageConstant;
import com.citichma.common.util.Check;
import com.citichma.common.util.FileUtil;
import com.citichma.common.util.FtpUtil;
import com.citichma.common.util.IDUtils;
import com.citichma.common.util.UserUtil;
import com.citichma.common.vo.DataResult;
import com.citichma.common.vo.UserInfoVo;
import com.citichma.pojo.FileUpload;
import com.citichma.service.FileUploadService;
/**
 * 
 * 文件上传处理类
 * @author JIXD 
 * @date 2016年8月7日 下午6:35:47  
 *
 */
@Controller
@RequestMapping("/file")
public class FileController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private FileUploadService fuService;
	
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${FILE_BASE_URL}")
	private String FILE_BASE_URL;
	@Value("${FILE_LOCAL_PATH}")
	private String FILE_LOCAL_PATH;
	
	
	/**
	 * 
	 * 文件上传 
	 * @param   
	 * @return 
	 * @date 2016年8月14日 下午1:48:33  
	 * @throws
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(MultipartFile uploadFile,String extra){
		if(Check.NuNObj(extra)){
			return JSONObject.toJSONString(DataResult.build(HttpStatus.BAD_REQUEST.value(), "ID不存在"));
		}
		UserInfoVo currentUser = UserUtil.getCurrentUser();
		if(Check.NuNObj(currentUser)){
			return JSONObject.toJSONString(DataResult.build(HttpStatus.BAD_REQUEST.value(), "会话失效，请重新登陆"));
		}
		if(Check.NuNObj(uploadFile)){
			return JSONObject.toJSONString(DataResult.build(HttpStatus.BAD_REQUEST.value(), "文件不存在"));
		}
		try {
			FileUpload fu = new FileUpload();
			fu.setCreateId(currentUser.getUserId());
			fu.setFileSize((int)uploadFile.getSize());
			fu.setPlanId(Integer.parseInt(extra));
			fu.setFileName(uploadFile.getOriginalFilename());
			String oldName = uploadFile.getOriginalFilename();
			String newName = IDUtils.genImageName();
			
			String filePath = new DateTime().toString("yyyy\\MM\\dd");
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			
			//filezilla上传方法
			/*boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH,
					filePath, newName, uploadFile.getInputStream());
			if(result){
				fu.setFileUrl(filePath+"/"+newName);
				int count = fuService.saveFileUpload(fu);
				if(count > 0){
					fu.setFileUrl(FILE_BASE_URL+ FTP_BASE_PATH +"/"+ filePath+"/"+newName);
					return JSONObject.toJSONString(DataResult.ok(fu));
				}else{
					return JSONObject.toJSONString(DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(),"上传文件失败"));
				}
			}else{
				return JSONObject.toJSONString(DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(),"上传文件失败"));
			}*/
			String realPath = FILE_LOCAL_PATH + File.separator + FTP_BASE_PATH + File.separator + filePath + File.separator + newName;
			
			File file = new File(realPath);
			File parentFile =file.getParentFile();
			if(!parentFile.exists()){
				parentFile.mkdirs();
			}
			if(!file.exists()){
				file.createNewFile();
			}
			InputStream in = uploadFile.getInputStream();
			FileOutputStream out = new FileOutputStream(realPath);
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len=in.read(buffer))>0){
				out.write(buffer, 0, len);
			}
			
			in.close();
			out.close();
			
			fu.setFileUrl(filePath+"\\"+newName);
			int count = fuService.saveFileUpload(fu);
			
			if(count > 0){
				fu.setFileUrl(FILE_BASE_URL+"/"+ filePath.replace("\\", "/")+"/"+newName);
				return JSONObject.toJSONString(DataResult.ok(fu));
			}else{
				return JSONObject.toJSONString(DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(),"上传文件失败"));
			}
		}catch(Exception e){
			LOGGER.error("上传文件异常",e);
			return JSONObject.toJSONString(DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(),"服务异常"));
		}
		
	}
	
	/**
	 * 
	 * 删除文件 
	 * @param   
	 * @return 
	 * @date 2016年8月14日 下午6:31:48  
	 * @throws
	 */
	@RequestMapping("/del/{id}")
	@ResponseBody
	public DataResult delFile(@PathVariable(value="id") Integer id){
		if(Check.NuNObj(id)){
			return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.ID_NULL);
		}
		FileUpload findFile = fuService.findFileById(id);
		if(!Check.NuNObj(findFile)){
			int count = fuService.delFile(id);
			if(count > 0){
				String url = findFile.getFileUrl();
				String location = FILE_LOCAL_PATH + "\\"+FTP_BASE_PATH + "\\"+ url;
				File file = new File(location);
				if(file.exists()){
					file.delete();
				}
				return DataResult.ok();
			}else{
				return DataResult.build(HttpStatus.SERVICE_UNAVAILABLE.value(), MessageConstant.SERVER_ERROR);
			}
		}
		return DataResult.ok();
	}
	
}
