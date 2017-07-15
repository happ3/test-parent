package com.test.core.cache;

import java.util.concurrent.TimeUnit;

import com.test.base.repository.UserInfo;

public interface UserInfoCache {
		
	void set(UserInfo userInfo);
	
	UserInfo get(int id);
	
	void set(UserInfo userInfo, long timeout, TimeUnit unit);
	
	void del(int id);
	
	void setByUserName(UserInfo userInfo);
	
	void getByUserName(UserInfo userInfo);
	
	void delByUserName(String userName);
	
	
}
