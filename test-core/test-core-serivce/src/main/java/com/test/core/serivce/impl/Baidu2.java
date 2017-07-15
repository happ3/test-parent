package com.test.core.serivce.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.DateUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.test.common.unit.HttpClientUtils;

import baidu.BaiFuBaoConstants;
import baidu.BaiFuBaoResultBase;
import baidu.BaiFuBaoScannerParam;

public class Baidu2 {
	public static void main(String[] args) {
		xiadan();
	}

	private static void xiadan() {
		
		   BaiFuBaoScannerParam baiFuBaoScannerParam = new BaiFuBaoScannerParam();
	        baiFuBaoScannerParam.setServiceCode(BaiFuBaoConstants.SERVICE_CODE);
	        baiFuBaoScannerParam.setSpNo("3400000001");
	        baiFuBaoScannerParam.setOrderCreateTime(DateUtils.formatDate(new Date(),"yyyyMMddHHmmss"));
	        baiFuBaoScannerParam.setOrderNo(System.currentTimeMillis()+"");
	        baiFuBaoScannerParam.setGoodsName("test");
	        baiFuBaoScannerParam.setTotalAmount("1");
	        baiFuBaoScannerParam.setCurrency(BaiFuBaoConstants.CURRENCY);
	        baiFuBaoScannerParam.setReturnUrl("http://www.baidu.com");
	        baiFuBaoScannerParam.setPayType(BaiFuBaoConstants.PAYTYPE);
	        baiFuBaoScannerParam.setInputCharset(BaiFuBaoConstants.INPUT_CHARSET);
	        baiFuBaoScannerParam.setVersion(BaiFuBaoConstants.VERSION);
	        baiFuBaoScannerParam.setSignMethod(BaiFuBaoConstants.SIGN_METHOD);
	        long sysdate = System.currentTimeMillis();
	        baiFuBaoScannerParam.setExpireTime(DateUtils.formatDate(new Date(sysdate + 6*60*1000),"yyyyMMddHHmmss"));
		
	        Baidu2 baidu = new Baidu2();
	        BaiFuBaoScannerParam baiFuBaoScannerPara = baidu.payRefundQuery(baiFuBaoScannerParam, "Au88LPiP5vaN5FNABBa7NC4aQV28awRK");
	        
	        System.out.println(baiFuBaoScannerPara);
		
	}
	
	public BaiFuBaoScannerParam payRefundQuery(BaiFuBaoScannerParam baiFuBaoScannerParam, String key){
		HttpUriRequest httpUriRequest = createRequest(baiFuBaoScannerParam, key, "https://www.baifubao.com/api/0/pay/0/wapdirect/0");
		BaiFuBaoResultBase baiFuBaoResultBase =  HttpClientUtils.execute(httpUriRequest,BaiFuBaoResultBase.class);
//		HttpEntity httpEntity = httpResponse.getEntity();
//		try {
//			String  result = EntityUtils.toString(httpEntity);
//			System.out.println(result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 return null;
	}
	
	
	protected static Header fromHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.TEXT_PLAIN.toString());
	private HttpUriRequest createRequest(BaiFuBaoScannerParam requestParams, String key, String uri) {
		if(requestParams == null || key == null){
			throw new IllegalArgumentException("requestParams and key is can't empty !");
		}
		if (key != null) {
			String sign = generateSign(requestParams,key);
			requestParams.setSign(sign);
		}
		
		 requestParams.setOutputType(BaiFuBaoConstants.OUTPUT_TYPE);
		 String json = JSON.toJSONString(requestParams);
         @SuppressWarnings("unchecked")
		 Map<String, String> map = (Map<String, String>) JSON.parse(json);
         String param =MapUtil.mapJoin(map, false, false);
         
        
         
         param = sendGet(uri, param);
         System.out.println(param);
         
		HttpUriRequest httpUriRequest = RequestBuilder.get().setUri(uri).setEntity(new StringEntity(param, Charset.forName("utf-8"))).build();
		return httpUriRequest;
	}

	private String generateSign(BaiFuBaoScannerParam requestParams,String key) {
		 String json = JSON.toJSONString(requestParams);
         Map<String, String> map = (Map<String, String>) JSON.parse(json);
         String param = MapUtil.mapJoin(MapUtil.order(map), false, false)+"&key="+key;
         return md5Digest(param);
    }
	//MD5签名算法
		public final static String md5Digest(String res) {
			if(res ==null||"".equals(res)){
				return null;
			}
			char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
			byte[] strTemp;
			try {
				strTemp = res.getBytes("gbk");
			} catch (UnsupportedEncodingException e1) {
				return null;
			}
			try {
				MessageDigest mdTemp = MessageDigest.getInstance("MD5");
				mdTemp.update(strTemp);
				byte[] md = mdTemp.digest();
				int j = md.length;
				char str[] = new char[j * 2];
				int k = 0;
				for (int i = 0; i < j; i++) {
					byte byte0 = md[i];
					str[k++] = hexDigits[byte0 >>> 4 & 0xf];
					str[k++] = hexDigits[byte0 & 0xf];
				}
				String dd = new String(str);
				return dd;
			} catch (Exception e) {
				return null;
			}
		}
		
		 public static String sendGet(String url, String param) {
		        String result = "";
		        BufferedReader in = null;
		        try {
		            String urlNameString = url + "?" + param;
		            URL realUrl = new URL(urlNameString);
		            // 打开和URL之间的连接
		            URLConnection connection = realUrl.openConnection();
		            // 设置通用的请求属性
		            connection.setRequestProperty("accept", "*/*");
		            connection.setRequestProperty("connection", "Keep-Alive");
		            connection.setRequestProperty("user-agent",
		                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		            // 建立实际的连接
		            connection.connect();
		            // 定义 BufferedReader输入流来读取URL的响应
		            in = new BufferedReader(new InputStreamReader(
		                    connection.getInputStream()));
		            String line;
		            while ((line = in.readLine()) != null) {
		                result += line;
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        // 使用finally块来关闭输入流
		        finally {
		            try {
		                if (in != null) {
		                    in.close();
		                }
		            } catch (Exception e2) {
		                e2.printStackTrace();
		            }
		        }
		        return result;
		    }
}
