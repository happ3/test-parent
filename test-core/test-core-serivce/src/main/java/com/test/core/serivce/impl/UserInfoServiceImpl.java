package com.test.core.serivce.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.base.repository.UserInfo;
import com.test.base.repository.UserInfoExample;
import com.test.core.dao.UserInfoDao;
import com.test.core.log.Test;
import com.test.core.serivce.UserInfoService;

@Service(value="userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	@Resource(name="userInfoDao")
	UserInfoDao userInfoDao;

	@Override
	public Map<String, Object> findAllUserInfo(Map<String, Object> params) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		
		UserInfoExample userInfoExample = new UserInfoExample();
//		UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
		
		int total = userInfoDao.countUserInfo(userInfoExample);
		
//		if(null == params.get("start") || "".equals(params.get("start"))){return resultMap;}
//		if(null == params.get("length") || "".equals(params.get("length"))){return resultMap;}
		
//		int start = Integer.parseInt(params.get("start").toString());
//		int length = Integer.parseInt(params.get("length").toString());
		
		
//		Page page = new Page(start,length);
//		userInfoExample.setPage(page);
//		userInfoExample.setOrderByClause(" created desc");
		
		List<UserInfo> resultList = userInfoDao.findAllUserInfo(userInfoExample);
		resultMap.put("iTotalRecords", resultList.size());
		resultMap.put("iTotalDisplayRecords",total);
		resultMap.put("data", resultList);
		resultMap.put("code", total);
		
		return resultMap;
	}

	@Override
	@Test
	public Map<String, Object> getUserInfoById(Map<String, Object> params) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(null != params){
			if(null != params.get("id") && !"".equals(params.get("id"))){
				UserInfo userInfo = userInfoDao.getUserInfoById(Integer.parseInt(params.get("id").toString()));
				resultMap.put("resultMap", userInfo);
			}
		}
		return resultMap;
	}
	
	
	@Override
	public Map<String, Object> findByState(Map<String, Object> params) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(null != params){
			if(null != params.get("state") && !"".equals(params.get("state"))){
				List<UserInfo> userInfoList= userInfoDao.findByState(Integer.parseInt(params.get("state").toString()));
				resultMap.put("resultMap", userInfoList);
			}
		}
		return resultMap;
	}
	
}
