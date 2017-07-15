package com.test.core.serivce.impl;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

public class TestChannel {

	public static void main(String[] args) {
//		PreOrder preOrder = new PreOrder();
//		preOrder.setVersion("2.0");
//		preOrder.setSignType("SHA256");
//		preOrder.setCharset("utf-8");
//		preOrder.setOrderNum(String.valueOf(System.currentTimeMillis()));
//		preOrder.setTxndir("Q");
//		preOrder.setBusicd("PAUT");
//		preOrder.setInscd("10134001");
//		preOrder.setChcd("WXP");
//		preOrder.setMchntid("100000000000203");
//		preOrder.setTerminalid("xlsj0001");
//		preOrder.setTxamt("000000000001");
		
		PreOrder preOrder = new PreOrder();
		preOrder.setBackUrl(null);
		preOrder.setVersion("2.0");
		preOrder.setSignType("SHA256");
		preOrder.setCharset("utf-8");
		preOrder.setOrderNum(String.valueOf(System.currentTimeMillis()));
		preOrder.setOrigOrderNum("000000ca17f3441111702000163D8");
		preOrder.setTxndir("Q");
		preOrder.setBusicd("REFD");
		preOrder.setInscd("10134001");
		preOrder.setMchntid("100000000000203");
		preOrder.setTerminalid("xlsj0001");
		preOrder.setTxamt("000000000010");
		
		String sign = SHA256Encrypt(preOrder);
		preOrder.setSign(sign);
		
//		String getReq = MapUtil.mapJoin(MapUtil.objectToMap(preOrder), false, false);
		
//		System.out.println(getReq);
		String str = sendPost("http://test.quick.ipay.so/scanpay/unified", preOrder);//get请求
		System.out.println(str);
//		System.out.println(SHA256Encrypt(null));
	}
	
	

	 public static String SHA256Encrypt(PreOrder preOrder) {
	  String orignal = MapUtil.mapJoin(MapUtil.order(MapUtil.objectToMap(preOrder)), false, false);
	  orignal += "zsdfyreuoyamdphhaweyrjbvzkgfdycs";
	  System.out.println(orignal);
//		 String  orignal = "busicd=PAUT&charset=utf-8&chcd=WXP&inscd=10130001&mchntid=100000000000203&orderNum=1481008356321&signType=SHA256&terminalid=00000001&txamt=000000000001&txndir=Q&version=2.1zsdfyreuoyamdphhaweyrjbvzkgfdycs";
	  MessageDigest md = null;
	  try {
		  
		  md = MessageDigest.getInstance("SHA-256");
		  
	  	} catch (NoSuchAlgorithmException e) {
	  		e.printStackTrace();
	  	}
	  if (null != md) {
		   byte[] origBytes = orignal.getBytes();
		   md.update(origBytes);
		   byte[] digestRes = md.digest();
		   String digestStr = getDigestStr(digestRes);
		   return digestStr;
		  }
	  return null;
	 }
	 
	 
	 private static String getDigestStr(byte[] origBytes) {
		String tempStr = null;
	  	StringBuilder stb = new StringBuilder();
		  for (int i = 0; i < origBytes.length; i++) {
			  tempStr = Integer.toHexString(origBytes[i] & 0xff);
		   if (tempStr.length() == 1) {
			   stb.append("0");
		   }
		   stb.append(tempStr);
		  }
		  return stb.toString();
	 }
	
	
	 public static String sendPost(String url,Object jsonParam) {
	        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
	        CloseableHttpClient httpClient = httpClientBuilder.build();
	        HttpPost method = new HttpPost(url);
	        String resultStr = "";
	        try {
	        if(null != jsonParam){
	        	  StringEntity entity = new StringEntity(JSONObject.toJSONString(jsonParam), "utf-8");
	        	  entity.setContentEncoding("UTF-8");
	              entity.setContentType("application/json");
	              method.setEntity(entity);
	        }
				HttpResponse result = httpClient.execute(method);
				resultStr = EntityUtils.toString(result.getEntity(),"UTF-8");
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
	            try {
	                httpClient.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
		return resultStr;
		 
	 }
}
