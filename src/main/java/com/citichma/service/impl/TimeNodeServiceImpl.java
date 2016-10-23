package com.citichma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citichma.common.util.Check;
import com.citichma.mapper.TimeNodeMapper;
import com.citichma.pojo.TimeNode;
import com.citichma.service.TimeNodeService;

/**
 * 
 * 时间节点服务类
 * @author JIXD 
 * @date 2016年8月7日 下午12:48:44  
 *
 */
@Service
public class TimeNodeServiceImpl implements TimeNodeService {

	@Autowired
	private TimeNodeMapper timeNodeMapper;
	
	@Override
	public int saveTimeNode(TimeNode timeNode) {
		return timeNodeMapper.insertSelective(timeNode);
	}

	@Override
	public int updateTimeNode(TimeNode timeNode) {
		return timeNodeMapper.updateByPrimaryKeySelective(timeNode);
	}

	@Override
	public int saveOrUpdateTimeNode(TimeNode timeNode) {
		int count = 0;
		if(Check.NuNObj(timeNode.getId())){
			count = timeNodeMapper.insertSelective(timeNode);
		}else{
			count = timeNodeMapper.updateByPrimaryKeySelective(timeNode);
		}
		return count;
	}

}
