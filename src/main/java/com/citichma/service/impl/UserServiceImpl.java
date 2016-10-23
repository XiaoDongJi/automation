package com.citichma.service.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citichma.common.request.UserRequestParam;
import com.citichma.common.util.Check;
import com.citichma.common.vo.EUDataGridResult;
import com.citichma.common.vo.UserInfoVo;
import com.citichma.mapper.TUserMapper;
import com.citichma.pojo.TUser;
import com.citichma.pojo.TUserExample;
import com.citichma.pojo.TUserExample.Criteria;
import com.citichma.service.UserService;
import com.citichma.valenum.IsDelEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 
 * @Description: 用户服务
 * @author JIXD 
 * @date 2016年7月5日 下午9:33:18  
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private TUserMapper userMapper; 
	
	@Override
	public int saveUser(TUser user) {
		return userMapper.insertSelective(user);
	}

	@Override
	public int updateUser(TUser user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public TUser findUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public EUDataGridResult findUserByPage(UserRequestParam userParam) {
		TUserExample tUserExample = new TUserExample();
		Criteria criteria = tUserExample.createCriteria();
		criteria.andIsDelEqualTo(IsDelEnum.NO_DEL.getCode());
		if(!Check.NuNStr(userParam.getUserNo())){
			criteria.andUserNoEqualTo(userParam.getUserNo());
		}
		if(!Check.NuNStr(userParam.getUserName())){
			criteria.andUserNameEqualTo(userParam.getUserName());
		}
		PageHelper.startPage(userParam.getPage(), userParam.getRows());
		List<TUser> userList = userMapper.selectByExample(tUserExample);
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(userList);
		PageInfo<TUser> pageInfo = new PageInfo<>(userList);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public TUser findUserByNo(String userNo) {
		return userMapper.selectByUserNo(userNo);
	}

	@Override
	public UserInfoVo findUserVoByUid(Integer userId) {
		return userMapper.findUserVoByUid(userId);
	}

}
