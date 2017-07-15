package weifutong;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.DateUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

import com.test.common.unit.HttpClientUtils;
import com.test.common.unit.XMLConverUtil;
import com.test.core.serivce.impl.MapUtil;

public class TestWEi {

//	public static void main(String[] args) {
////		Date d = new Date();  
////        SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//12小时制  
////        System.out.println(ss.format(d));  
//  
//        Date date = new Date();  
//        SimpleDateFormat sdformat = new SimpleDateFormat("yyyyMMddHHmmss");//24小时制  
//        String LgTime = sdformat.format(date);  
//        LgTime =  DateUtil.format(new Date(),"yyyyMMddHHmmss");
//        System.out.println(LgTime);  
//	}
	
	public static void main(String[] args) {
		
		SwiftpassScannerParam swiftpassQueryParam = new SwiftpassScannerParam();
//		swiftpassScannerParam.setService("unified.trade.micropay");
//		swiftpassScannerParam.setVersion("2.0");
//		swiftpassScannerParam.setCharset("UTF-8");
//		swiftpassScannerParam.setSign_type("MD5");
//		swiftpassScannerParam.setMch_id("7551000001");
////		swiftpassScannerParam.setGroupno(groupno);
//		swiftpassScannerParam.setOut_trade_no(System.currentTimeMillis()+"");
//		swiftpassScannerParam.setDevice_info(System.currentTimeMillis()+"");
//		swiftpassScannerParam.setBody(System.currentTimeMillis()+"");
//		swiftpassScannerParam.setTotal_fee("1");
//		swiftpassScannerParam.setMch_create_ip("8.8.8.8");
//		swiftpassScannerParam.setAuth_code("130265826401239893");
//		swiftpassScannerParam.setTime_start(DateUtil.format(new Date(),"yyyyMMddHHmmss"));
//		long sysdate = System.currentTimeMillis();
//		swiftpassScannerParam.setTime_expire(DateUtil.format(new Date(sysdate + 2*60*1000),"yyyyMMddHHmmss"));
//		
////		swiftpassScannerParam.setTime_expire(time_expire);
//		swiftpassScannerParam.setNonce_str(System.currentTimeMillis()+"");
		
		
		swiftpassQueryParam.setService("unified.trade.query");
        swiftpassQueryParam.setVersion("2.0");
        swiftpassQueryParam.setCharset("UTF-8");
        swiftpassQueryParam.setSign_type("MD5");
        swiftpassQueryParam.setMch_id("199580172598");
        swiftpassQueryParam.setOut_trade_no("P184215507598049152");
        swiftpassQueryParam.setNonce_str(System.currentTimeMillis()+"");
		
		SwiftpassScannerResult swiftpassScannerResult = payRefundQuery(swiftpassQueryParam, "fa4f1b133d0aa81f9e64975dcd52f03f");
		System.out.println(swiftpassScannerResult.toString());
	}
	
	
	public static SwiftpassScannerResult payRefundQuery(SwiftpassScannerParam swiftpassScannerParam, String key) {
		HttpUriRequest httpUriRequest = createRequest(swiftpassScannerParam, key, "https://pay.swiftpass.cn/pay/gateway");
		return HttpClientUtils.executeXmlResult(httpUriRequest, SwiftpassScannerResult.class);
	}

	protected static Header xmlHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.APPLICATION_XML.toString());
	private static HttpUriRequest createRequest(SwiftpassScannerParam requestParams, String key, String uri) {
		if(requestParams == null || key == null){
			throw new IllegalArgumentException("requestParams and key is can't empty !");
		}
		Map<String, String> map = MapUtil.objectToMap(requestParams);
		if (key != null) {
			String sign = generateSign(map, key);
			requestParams.setSign(sign);
		}
		String unifiedorderXML = XMLConverUtil.convertToXML(requestParams);
		
//		unifiedorderXML = "<xml>"+
//	    "<charset>UTF-8</charset>"+
//	    "<mch_id>7551000001</mch_id>"+
//	    "<nonce_str>1494347009319</nonce_str>"+
//	    "<out_trade_no>P183216517301665664</out_trade_no>"+
//	    "<service>unified.trade.micropay</service>"+
//	    "<sign>42AC5ED570264D156B6DF61C1B4F886A</sign>"+
//	    "<sign_type>MD5</sign_type>"+
//	    "<version>2.0</version>"+
//	    "<device_info>4111170516020084</device_info>"+
//	    "<body>1494347009319</body>"+
//	    "<total_fee>1</total_fee>"+
//	    "<mch_create_ip>192.168.5.171</mch_create_ip>"+
//	    "<auth_code>130022767943690790</auth_code>"+
//	    "<time_start>20172309042329</time_start>"+
//	    "<time_expire>20172409042429</time_expire>"+
//	"</xml>";       
	
	
		System.out.println(unifiedorderXML);
		HttpUriRequest httpUriRequest = RequestBuilder.post().setHeader(xmlHeader).setUri(uri)
				.setEntity(new StringEntity(unifiedorderXML, Charset.forName("UTF-8"))).build();
		return httpUriRequest;
	}


	private static String generateSign(Map<String, String> map, String key) {
		 String orignal = MapUtil.mapJoin(MapUtil.order(map), false, false)+"&key="+key;
		 return md5Digest(orignal).toUpperCase();
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
	
}
