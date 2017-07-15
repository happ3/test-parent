package com.test.web.userinfo;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.core.serivce.UserInfoService;

@RestController
public class UserInfoController {
	
	@Resource(name="userInfoService")
	private UserInfoService userInfoService;
	
	@RequestMapping(value = "findAllUserInfo", method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> findAllUserInfo(Map<String, Object> params) {
        Map<String,Object> map= userInfoService.findAllUserInfo(params);
        return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
    }
	
	@RequestMapping(value = "getUserInfoById", method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> getUserInfoById(@RequestBody Map<String, Object> params) {
		Map<String,Object> map= userInfoService.getUserInfoById(params);
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value = "findByState", method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> findByState(@RequestBody Map<String, Object> params) {
		Map<String,Object> map= userInfoService.findByState(params);
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
}
