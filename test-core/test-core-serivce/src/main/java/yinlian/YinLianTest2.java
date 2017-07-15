package yinlian;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.test.core.serivce.impl.MapUtil;
import com.unionpay.acp.sdk.AcpService;

import weifutong.DateUtil;

public class YinLianTest2 {

	
	public static void main(String[] args) {
		UnionPayScannerParam unionPayScannerParam = new UnionPayScannerParam();
			unionPayScannerParam.setVersion(UnionPayConstants.VERSION);
			unionPayScannerParam.setEncoding(UnionPayConstants.ENCODING);
			unionPayScannerParam.setSignMethod(UnionPayConstants.SIGN_METHOD);
			unionPayScannerParam.setTxnType("01");
			unionPayScannerParam.setTxnSubType("06");
			unionPayScannerParam.setBizType(UnionPayConstants.BIZ_TYPE);
			unionPayScannerParam.setChannelType(UnionPayConstants.CHANNEL_TYPE);
			unionPayScannerParam.setAccessType(UnionPayConstants.ACCESS_TYPE);
			unionPayScannerParam.setOrderId("P199126198473719680");
			unionPayScannerParam.setTxnTime("20170622100256");
			unionPayScannerParam.setTxnAmt("1");
			unionPayScannerParam.setCurrencyCode(UnionPayConstants.CURRENCY_CODE);
			unionPayScannerParam.setMerId("898310173990682");
			unionPayScannerParam.setQrNo("6224497211547039297");
			unionPayScannerParam.setBackUrl("http://www.baidu.com");
		
		
		UnionPayUnifiedeResult unifiedeResult = payRefundQuery(unionPayScannerParam,"D:/certs", "690085");
		System.out.println(JSON.toJSON(unifiedeResult));
	}
	
	
	public static UnionPayUnifiedeResult payRefundQuery(UnionPayParamBase param,String path, String key) {
		Map<String, String> reqData = SignUnit.createRequest(MapUtil.objectToMap(param),path,key);
//		Map<String, String> rspData = AcpService.post(reqData,"https://gateway.test.95516.com/gateway/api/backTransReq.do","UTF-8");
//		String strr = "{\"bizType\":\"000000\",\"backUrl\":\"http://www.baidu.com\",\"txnSubType\":\"06\",\"orderId\":\"P199120609769160576\",\"signature\":\"JkJ4uW44ZKtnkj0l5Oye1QCFyyoAfFtIxoXS7BqUR/Xwh2A0BiCorQfhJweqxCa2F2FzacogKkz+JI7rdBAJVs7aUQH26VNifmt3IKVTeAYIafs+ZRi28QcizD9bU7w8goImhhZR1+uSDsOxcf3G0Ku4NS8kJLMsCir3B4RhmQaBaWG2TouLXHHIdERhRvsoHR4RB6FTZxOURRYTSYPGOqCUlfr9dweQ+P4yd93i7Iy/4tHZFKZk9W5uhebs3i0VyHcZpUH2AU1K869/jXKzEJVPqrot5xfNq2PQoq+i2sFfXiyhdMw94FFXn+UDhpTtb7LJFQDPJiBmfR5rpGP9Pw==\",\"channelType\":\"08\",\"txnType\":\"01\",\"certId\":\"70869139479\",\"encoding\":\"UTF-8\",\"version\":\"5.1.0\",\"accessType\":\"0\",\"qrNo\":\"6224857848804911600\",\"txnTime\":\"20170622094042\",\"merId\":\"898310173990682\",\"currencyCode\":\"156\",\"txnAmt\":\"1\",\"signMethod\":\"01\"}";
//		UnionPayScannerParam unionPayScannerParam = JSON.parseObject(strr,UnionPayScannerParam.class);
//		String str  = doPost(MapUtil.objectToMap(unionPayScannerParam),"https://gateway.95516.com/gateway/api/backTransReq.do","UTF-8");

				String str  = doPost(reqData,"https://gateway.95516.com/gateway/api/backTransReq.do","UTF-8");
		return JSON.parseObject(JSON.toJSONString(getUrlParams(str)), UnionPayUnifiedeResult.class);
	}

	public static String doPost(Map<String, String> reqData,String uriAPI,String encoding){
		String result = "";

        try {
            HttpPost e = new HttpPost(uriAPI);
            ArrayList params = new ArrayList();
            Iterator httpclient = reqData.entrySet().iterator();

            while(httpclient.hasNext()) {
                Entry httpResponse = (Entry)httpclient.next();
                params.add(new BasicNameValuePair((String)httpResponse.getKey(), (String)httpResponse.getValue()));
            }

            e.setEntity(new UrlEncodedFormEntity(params, encoding));
            CloseableHttpClient httpclient1 = HttpClients.createDefault();
            CloseableHttpResponse httpResponse1 = httpclient1.execute(e);
            if(httpResponse1.getStatusLine().getStatusCode() == 200) {
                HttpEntity httpEntity = httpResponse1.getEntity();
                result = EntityUtils.toString(httpEntity);
            }
        } catch (Exception var9) {
            var9.printStackTrace();
            result = var9.getMessage().toString();
        }

        return result;
    }
	
	   public static Map<String, String> getUrlParams(String param) {
	        Map<String, String> map = new HashMap<String, String>(0);
	        String[] params = param.split("&");
	        for (int i = 0; i < params.length; i++) {
	            String[] p = params[i].split("=");
	            if (p.length == 2) {
	                map.put(p[0], p[1]);
	            }
	        }
	        return map;
	    }
}
