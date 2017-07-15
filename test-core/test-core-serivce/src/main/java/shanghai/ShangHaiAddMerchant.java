package shanghai;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

import com.test.common.unit.HttpClientUtils;
import com.test.common.unit.XMLConverUtil;
import com.test.core.serivce.impl.MapUtil;

public class ShangHaiAddMerchant {

	public static void main(String[] args) {
		
		MerchantReq merchantReq = new MerchantReq();
		merchantReq.setMerchantId("1000001");
		merchantReq.setAction("createshop");
		merchantReq.setWxFee("60,60,60");
		merchantReq.setZfbFee("60,60,60");
		merchantReq.setAccountType("0");
		merchantReq.setBankType("1");
		merchantReq.setBankName("林海鹏");
		merchantReq.setBank("招商银行股份有限公司北京西二旗支行");
		merchantReq.setBankAccount("6214830164261629");
		merchantReq.setBankNum("308100005570");
		merchantReq.setShopName("张三的店");
		merchantReq.setCompanyName("张三餐饮有限公司");
		merchantReq.setServicePhone("4000111111");
		merchantReq.setContactName("张三");
		merchantReq.setContactPhone("13511111111");
		merchantReq.setAddress("公司地址");
		merchantReq.setNonceStr(System.currentTimeMillis()+"");
		merchantReq.setSource("111111111111");
		

		MerchantReturn merchantReturn= payRefundQuery(merchantReq,"uzl9ezhbhao0c5xfayaufaddb3aatrod");
		System.out.println(merchantReturn);
		
		
//		String stringA="appid=wxd930ea5d5a258f4f&body=test&device_info=1000&mch_id=10000100&nonce_str=ibuaiVcKdpRxkhJA"; 
//		stringA +="&key=192006250b4c09247ec02edce69f6a2d";
//		
//		System.out.println(md5Digest(stringA).toUpperCase());

	}
	
	public static MerchantReturn payRefundQuery(MerchantReq merchantReq, String key) {
		HttpUriRequest httpUriRequest = createRequest(merchantReq, key, "http://m.pay9.cn/merchant.php");
		return HttpClientUtils.executeXmlResult(httpUriRequest, MerchantReturn.class);
	}
	
	protected static Header xmlHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.APPLICATION_XML.toString());
	
	private static HttpUriRequest createRequest(MerchantReq merchantReq, String key, String uri) {
		if (key != null) {
			String sign = generateSign(merchantReq, key);
			merchantReq.setSign(sign);
		}
		String unifiedorderXML = XMLConverUtil.convertToXML(merchantReq);
		unifiedorderXML = unifiedorderXML.substring(unifiedorderXML.indexOf("<xml>"));
		
		System.out.print("报文:"+unifiedorderXML);
		HttpUriRequest httpUriRequest = RequestBuilder.post().setHeader(xmlHeader).setUri(uri)
				.setEntity(new StringEntity(unifiedorderXML, Charset.forName("utf-8"))).build();
		return httpUriRequest;
	}

	private static String generateSign(MerchantReq merchantReq, String key) {
		

		Map<String,String> map =new HashMap<String,String>();
		map.put("merchant_id", merchantReq.getMerchantId());
		map.put("action", merchantReq.getAction());
		map.put("wx_fee", merchantReq.getWxFee());
		map.put("zfb_fee", merchantReq.getZfbFee());
		map.put("account_type", merchantReq.getAccountType());
		map.put("bank_type", merchantReq.getBankType());
		map.put("bank_name", merchantReq.getBankName());
		map.put("bank", merchantReq.getBank());
		map.put("bank_account", merchantReq.getBankAccount());
		map.put("bank_num", merchantReq.getBankNum());
		map.put("shop_name", merchantReq.getShopName());
		map.put("company_name", merchantReq.getCompanyName());
		map.put("service_phone", merchantReq.getServicePhone());
		map.put("contact_name", merchantReq.getContactName());
		map.put("contact_phone", merchantReq.getContactPhone());
		map.put("address", merchantReq.getAddress());
		map.put("nonce_str", merchantReq.getNonceStr());
		map.put("source", merchantReq.getSource());
		
		String orignal = MapUtil.mapJoin(MapUtil.order(map), false, false)+"&key="+key.toUpperCase();
		System.out.println("签名字符串:"+ orignal);
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
