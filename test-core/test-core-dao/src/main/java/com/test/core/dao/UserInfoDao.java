package com.test.core.dao;

import java.util.List;

import com.test.base.repository.UserInfo;
import com.test.base.repository.UserInfoExample;

public interface UserInfoDao {

	List<UserInfo> findAllUserInfo(UserInfoExample userInfoExample);

	int countUserInfo(UserInfoExample userInfoExample);

	UserInfo getUserInfoById(int id);

	List<UserInfo> findByState(int parseInt);

}
