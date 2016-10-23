package com.citichma.common.util;

import java.io.File;
/**
 * 
 * 删除文件方法
 * @author JIXD 
 * @date 2016年8月14日 下午6:48:39  
 *
 */
public class FileUtil {
	
	/**
	 * 
	 * 删除文件 
	 * @param   
	 * @return 
	 * @date 2016年8月14日 下午6:48:29  
	 * @throws
	 */
	public static boolean deleteFile(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}  
}
