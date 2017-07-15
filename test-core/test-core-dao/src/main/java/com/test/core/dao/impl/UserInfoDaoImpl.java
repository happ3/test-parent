package com.test.core.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.test.base.repository.UserInfo;
import com.test.base.repository.UserInfoExample;
import com.test.core.cache.UserInfoCache;
import com.test.core.dao.UserInfoDao;
import com.test.core.dao.mapper.UserInfoMapper;
@Repository(value="userInfoDao")
public class UserInfoDaoImpl implements UserInfoDao {
	
	@Resource(name="userInfoMapper")
	UserInfoMapper userInfoMapper;

	@Resource(name="userInfoCache")
	UserInfoCache userInfoCache;
	
	@Override
	public List<UserInfo> findAllUserInfo(UserInfoExample userInfoExample) {
		List<UserInfo>  list = userInfoMapper.selectByExample(userInfoExample);
		if(null != list){
			userInfoCache.set(list.get(0));
		}
		return list;
	}

	@Override
	public int countUserInfo(UserInfoExample userInfoExample) {
		return userInfoMapper.countByExample(userInfoExample);
	}

	@Override
	public UserInfo getUserInfoById(int id) {
		return userInfoMapper.getUserInfoById(id);
	}

	@Override
	public List<UserInfo> findByState(int state) {
		return userInfoMapper.findByState(state);
	}


}
