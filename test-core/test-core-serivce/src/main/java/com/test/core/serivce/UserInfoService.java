package com.test.core.serivce;

import java.util.Map;

public interface UserInfoService {

	Map<String, Object> findAllUserInfo(Map<String, Object> params);

	Map<String, Object> getUserInfoById(Map<String, Object> params);

	Map<String, Object> findByState(Map<String, Object> params);

}
