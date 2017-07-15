package com.test.core.serivce.impl;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

import com.test.common.unit.HttpClientUtils;
import com.test.common.unit.JsonUtil;

public class TestYuXiaDan {
	protected static Header jsonHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.APPLICATION_JSON.toString());
	public static void main(String[] args) {
		
//	xiadan();//下单
//	chaxun();//查询
	tuikuan();
	}
	
	
	private static void chaxun() {

		TestYuXiaDan dan = new TestYuXiaDan();
		PreOrder preOrder = new PreOrder();
		preOrder.setVersion("2.0");
		preOrder.setSignType("SHA256");
		preOrder.setCharset("utf-8");
		preOrder.setOrigOrderNum("000149084311541111611000116C1");
		preOrder.setTxndir("Q");
		preOrder.setBusicd("INQY");
		preOrder.setTxamt("000000000001");
		preOrder.setInscd("10134001");
		preOrder.setMchntid("100000000000203");
		preOrder.setTerminalid("xlsj0001");
		
		String key ="zsdfyreuoyamdphhaweyrjbvzkgfdycs";
		preOrder = dan.payRefundQuery(preOrder, key);
		System.out.println(preOrder.toString());
	
		 
	}


	/**
	 * 
	 */
	private static void xiadan(){

		TestYuXiaDan dan = new TestYuXiaDan();
		PreOrder preOrder = new PreOrder();
		preOrder.setBackUrl(null);
		preOrder.setVersion("2.0");
		preOrder.setSignType("SHA256");
		preOrder.setCharset("utf-8");
		preOrder.setOrderNum(String.valueOf(System.currentTimeMillis()));
		preOrder.setTxndir("Q");
		preOrder.setBusicd("PAUT");
		preOrder.setInscd("10134001");
		preOrder.setChcd("WXP");
		preOrder.setMchntid("100000000000203");
		preOrder.setTerminalid("xlsj0001");
		preOrder.setTxamt("000000000001");
//		backUrl
		String key ="zsdfyreuoyamdphhaweyrjbvzkgfdycs";
		preOrder = dan.payRefundQuery(preOrder, key);
		System.out.println(preOrder.toString());
	}/**
	 * 
	 */
	private static void tuikuan(){

		TestYuXiaDan dan = new TestYuXiaDan();
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
		preOrder.setTxamt("000000000001");
//		backUrl
		String key ="zsdfyreuoyamdphhaweyrjbvzkgfdycs";
		preOrder = dan.payRefundQuery(preOrder, key);
		System.out.println(preOrder.toString());
	}
	
	
	
	public PreOrder payRefundQuery(PreOrder preOrder, String key) {
		HttpUriRequest httpUriRequest = createRequest(preOrder, key, "http://test.quick.ipay.so/scanpay/unified");
		return HttpClientUtils.executeJsonResult(httpUriRequest, PreOrder.class);
	}



	private HttpUriRequest createRequest(PreOrder requestParams, String key, String uri) {

		if(requestParams == null || key == null){
			throw new IllegalArgumentException("requestParams and key is can't empty !");
		}
		Map<String, String> map = MapUtil.objectToMap(requestParams);
		if (key != null) {
			String sign = generateSign(map, key);
			requestParams.setSign(sign);
		}
		String unifiedorderJSON = JsonUtil.toJSONString(requestParams);
		System.out.println(unifiedorderJSON);
		HttpUriRequest httpUriRequest = RequestBuilder.post().setHeader(jsonHeader).setUri(uri)
				.setEntity(new StringEntity(unifiedorderJSON, Charset.forName("UTF-8"))).build();
		return httpUriRequest;
	}
	
	/**
	 * 生成sign MD5 加密 toUpperCase
	 * 
	 * @param map
	 * @param paternerKey
	 * @return
	 */
	public String generateSign(Map<String, String> map, String paternerKey) {
		  String orignal = MapUtil.mapJoin(MapUtil.order(map), false, false)+paternerKey;
		  StringBuilder stb = new StringBuilder();
		  MessageDigest md = null;
		  String tempStr = null;
		  try {
			  md = MessageDigest.getInstance("SHA-256");
		  	} catch (NoSuchAlgorithmException e) {
		  		e.printStackTrace();
		  	}
		  
		  if (null != md) {
			   byte[] origBytes = orignal.getBytes();
			   md.update(origBytes);
			   byte[] digestRes = md.digest();
			  
			   for (int i = 0; i < digestRes.length; i++) {
				  tempStr = Integer.toHexString(digestRes[i] & 0xff);
			   if (tempStr.length() == 1) {
				   stb.append("0");
			   }
			   stb.append(tempStr);
			  }
		  }
		  
		return stb.toString();
	}

//	private String getDigestStr(byte[] digestRes) {
//		String tempStr = null;
//	  	StringBuilder stb = new StringBuilder();
//		  for (int i = 0; i < digestRes.length; i++) {
//			  tempStr = Integer.toHexString(digestRes[i] & 0xff);
//		   if (tempStr.length() == 1) {
//			   stb.append("0");
//		   }
//		   stb.append(tempStr);
//		  }
//		  return stb.toString();
//	 }
}
