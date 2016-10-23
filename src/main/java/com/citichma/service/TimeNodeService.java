package com.citichma.service;

import com.citichma.pojo.TimeNode;

/**
 * 
 * 时间节点服务接口
 * @author JIXD 
 * @date 2016年8月7日 上午10:57:42  
 *
 */
public interface TimeNodeService {
	
	/**
	 * 
	 * 保存时间节点 
	 * @param   
	 * @return 
	 * @date 2016年8月7日 下午12:46:18  
	 * @throws
	 */
	int saveTimeNode(TimeNode timeNode);
	
	/**
	 * 
	 * 更新时间节点 
	 * @param   
	 * @return 
	 * @date 2016年8月7日 下午12:46:53  
	 * @throws
	 */
	int updateTimeNode(TimeNode timeNode);
	/**
	 * 
	 * 新增或者更新时间节点 
	 * @param   
	 * @return 
	 * @date 2016年8月9日 下午9:28:22  
	 * @throws
	 */
	int saveOrUpdateTimeNode(TimeNode timeNode);
	
}
