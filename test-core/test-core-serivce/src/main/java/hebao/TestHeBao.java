package hebao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.hisun.iposm.HiiposmUtil;
import com.test.common.unit.JsonUtil;

public class TestHeBao {

	
	
	public static void main(String[] args) {
		
		
		PFacOrder pFacOrder = new PFacOrder();
		pFacOrder.setStoreName("test");
		pFacOrder.setTotalFee(1);
		pFacOrder.setuOrderNo(System.currentTimeMillis()+"");
		HebaoConfig hebaoConfig = new HebaoConfig();
		hebaoConfig.setSpNo("888073148140002");
		hebaoConfig.setHebaoKey("9853hjutdtgdkypmh79iopkh0hyrdklop934wcnbdyuw41asdcvn85621nmbckm");
		Map<String, Object> paramMap = createUnifiedOrder(pFacOrder,hebaoConfig);
		HebaoUnifiedOrder hebaoUnifiedOrder =  createUnifiedOrder(paramMap);
		System.out.println(hebaoUnifiedOrder.getPayUrl());
	}
	
	
	
	
	//统一下订单接口
	public static HebaoUnifiedOrder createUnifiedOrder(Map<String, Object> paramMap) {
		HebaoUnifiedOrder hebaoUnifiedOrder = null;
		
		if(null != paramMap && paramMap.size()>0 && 
				null!= paramMap.get("param") && !"".equals(paramMap.get("param"))){
			
			
			try {
				String param = paramMap.get("param").toString();
				HiiposmUtil util = new HiiposmUtil();
				String res = util.sendAndRecv(HebaoBaseApI.UnifiedorderURL , param, HebaoBaseApI.CHARACTERSET);
				hebaoUnifiedOrder = JsonUtil.parseObject(urlToJson(res),HebaoUnifiedOrder.class);
				hebaoUnifiedOrder.setPayUrl(HebaoBaseApI.PayUrl+hebaoUnifiedOrder.getPayUrl());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return hebaoUnifiedOrder;
	}

		
		 public static String urlToJson(String param) {
				String str[]=param.split("&");
				String s = "{";
				for (int i = 0; i < str.length; i++) {
					if(i==str.length-1){
						s += "\""+str[i].replace("=", "\":\"")+"\"";
					}else{
						s += "\""+str[i].replace("=", "\":\"")+"\",";
					}
					
				}
				s +="}";
				return s;
		    }
	
	public static Map<String,Object> createUnifiedOrder(PFacOrder pFacOrder, HebaoConfig hebaoConfig) {
		
		Map<String,Object> map = new HashMap<String,Object>(); 
		
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		//商户会计日期（自定义）
		 String characterSet = HebaoBaseApI.CHARACTERSET;
		 String callbackUrl = HebaoBaseApI.Url;
		 String notifyUrl = HebaoBaseApI.NotifyUrl;
		 String ipAddress=HebaoBaseApI.IPADDRESS;
		 String merchantId = hebaoConfig.getSpNo();
		 String requestId = System.currentTimeMillis()+"";
		 String signType = HebaoBaseApI.SIGNTYPE;
		 String type = HebaoBaseApI.CASDIRECTPAYCONFIRM;
		 String version = HebaoBaseApI.VERSION;
		 
		 String amount = pFacOrder.getTotalFee().toString();
		 String currency = HebaoBaseApI.CURRENCY;
		 String orderDate = sdf.format(new Date()).substring(0, 8);
		 String orderId = pFacOrder.getuOrderNo();
		 String merAcDate = sdf.format(new Date()).substring(0, 8);
		 String period = HebaoBaseApI.PERIOD;

		 String periodUnit = HebaoBaseApI.PERIODUNIT;
		 String merchantAbbr = pFacOrder.getStoreName();
		 String productDesc = pFacOrder.getStoreName();
		 String productId = System.currentTimeMillis()+"";
		 String productName = pFacOrder.getStoreName();
		 String productNum = "1";
		 String reserved1 = pFacOrder.getStoreName();
		 String reserved2 = pFacOrder.getStoreName();
		 String userToken = HebaoBaseApI.getTel();
		 String showUrl = HebaoBaseApI.Url;
		 String couponsFlag = HebaoBaseApI.COUPONSFLAG;
		
			//-- 签名
			String signData =  characterSet  + callbackUrl  + notifyUrl + ipAddress + merchantId  + requestId 
					+ signType  + type 	+ version  	+ amount   + currency + orderDate 
					+ orderId  + merAcDate  	+ period  + periodUnit 
					+ merchantAbbr + productDesc  + productId + productName + productNum 
					+ reserved1  + reserved2 + userToken + showUrl
					+ couponsFlag;
			
			String signKey = hebaoConfig.getHebaoKey();
//					"9853hjutdtgdkypmh79iopkh0hyrdklop934wcnbdyuw41asdcvn85621nmbckm";
			HiiposmUtil util = new HiiposmUtil();
			String hmac = util.MD5Sign(signData, signKey);
//			String hmac = HiCryptUtils.cryptMd5(signData, signKey);
			
			//-- 请求报文
			String buf = "characterSet=" + characterSet 
					+ "&callbackUrl=" + callbackUrl 
					+ "&notifyUrl=" + notifyUrl 
					+ "&ipAddress=" + ipAddress 
					+ "&merchantId=" + merchantId 
					+ "&requestId=" + requestId 
					+ "&signType=" + signType 
					+ "&type=" + type 
					+ "&version=" + version
					+ "&amount=" + amount 
					+ "&currency=" + currency 
					+ "&orderDate=" + orderDate
					+ "&orderId=" + orderId 
					+ "&merAcDate=" +merAcDate 
					+ "&period=" + period
					+ "&periodUnit=" + periodUnit 
					+ "&merchantAbbr=" + merchantAbbr 
					+ "&productDesc="+ productDesc + "&productId=" + productId
					+ "&productName=" + productName 
					+ "&productNum="+ productNum + "" + "&reserved1=" + reserved1
					+ "&reserved2=" + reserved2 
					+ "&userToken=" + userToken 
					+ "&showUrl=" + showUrl 
					+ "&couponsFlag=" + couponsFlag;
			
			//-- 带上消息摘要
					buf =  buf +"&hmac=" + hmac ;
					map.put("param", buf);
		return map;
	}
	
	
}
