package com.test.core.cache.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.test.base.repository.UserInfo;
import com.test.core.cache.UserInfoCache;
import com.test.core.cache.base.BaseRedisCache;

@Component(value="userInfoCache")
public class UserInfoCacheImpl extends BaseRedisCache implements UserInfoCache {

	@Override
	public void set(UserInfo userInfo) {
		if(userInfo != null){
			this.set(USER_INFO + userInfo.getId(),userInfo);
		}
	}

	@Override
	public UserInfo get(int id) {
		return (UserInfo) this.get(USER_INFO + id);
	}

	@Override
	public void set(UserInfo userInfo, long timeout, TimeUnit unit) {
		if(userInfo != null)
			this.set(USER_INFO + userInfo.getId(),userInfo, timeout, unit);
	}

	@Override
	public void del(int id) {
		this.del(USER_INFO+id);
	}

	@Override
	public void setByUserName(UserInfo userInfo) {
		this.set(USER_INFO_USERNAME +userInfo.getUserName(),userInfo);
	}

	@Override
	public void delByUserName(String userName) {
		this.get(USER_INFO_USERNAME + userName);
	}

	@Override
	public void getByUserName(UserInfo userInfo) {
		this.get(USER_INFO_USERNAME + userInfo.getId());
	}

	
}
