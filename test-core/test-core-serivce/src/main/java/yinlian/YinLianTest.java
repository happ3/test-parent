package yinlian;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
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

public class YinLianTest {

	
	public static void main(String[] args) {
		UnionPayUnifiedeParam param =new UnionPayUnifiedeParam();
			param.setVersion(UnionPayConstants.VERSION);
			param.setEncoding(UnionPayConstants.ENCODING);
			param.setSignMethod(UnionPayConstants.SIGN_METHOD);
			param.setTxnType(UnionPayConstants.TXN_TYPE);
			param.setTxnSubType("07");
			param.setBizType(UnionPayConstants.BIZ_TYPE);
			param.setChannelType(UnionPayConstants.CHANNEL_TYPE);
			param.setAccessType(UnionPayConstants.ACCESS_TYPE);
			param.setOrderId(System.currentTimeMillis()+"");
			param.setTxnTime(DateUtil.format(new Date(), "yyyyMMddhhmmss"));
			param.setTxnAmt("1");
			param.setCurrencyCode(UnionPayConstants.CURRENCY_CODE);
			param.setBackUrl("http://222.222.222.222:8080/ACPSample_AppServer/backRcvResponse");
			param.setMerId("777290058147576");
		
		
			UnionPayUnifiedeResult unifiedeResult = payRefundQuery(param,"D:/certs", "000000");
			System.out.println(JSON.toJSON(unifiedeResult));
	}
	
	
	public static UnionPayUnifiedeResult payRefundQuery(UnionPayUnifiedeParam param,String path, String key) {
		Map<String, String> reqData = SignUnit.createRequest(MapUtil.objectToMap(param),path,key);
//		Map<String, String> rspData = AcpService.post(reqData,"https://gateway.test.95516.com/gateway/api/backTransReq.do","UTF-8");
		String str  = doPost(reqData,"https://gateway.test.95516.com/gateway/api/backTransReq.do","UTF-8");
		return JSON.parseObject(JSON.toJSONString(getUrlParams(str)), UnionPayUnifiedeResult.class);
	}

	public static String doPost(Map<String, String> reqData,String uriAPI,String encoding){
        String result = "";
        HttpPost httpRequst = new HttpPost(uriAPI);//创建HttpPost对象

        List <NameValuePair> params = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : reqData.entrySet()) {
        	params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }

        try {
            httpRequst.setEntity(new UrlEncodedFormEntity(params,encoding));
            CloseableHttpClient httpclient = HttpClients.createDefault();  
            HttpResponse httpResponse = httpclient.execute(httpRequst);
            if(httpResponse.getStatusLine().getStatusCode() == 200){
                HttpEntity httpEntity = httpResponse.getEntity();
                result = EntityUtils.toString(httpEntity);//取出应答字符串
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            result = e.getMessage().toString();
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
