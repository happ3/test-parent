package hebao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.hisun.iposm.HiiposmUtil;
import com.test.common.unit.JsonUtil;

public class TestBeiSao {

	
	public static void main(String[] args) {
		
		
		String codeData ="100498904982440770";
		PFacOrder pFacOrder = new PFacOrder();
		pFacOrder.setStoreName("test");
		pFacOrder.setTotalFee(1);
		pFacOrder.setuOrderNo(System.currentTimeMillis()+"");
		HebaoConfig hebaoConfig = new HebaoConfig();
		hebaoConfig.setSpNo("888073148140002");
		hebaoConfig.setHebaoKey("9853hjutdtgdkypmh79iopkh0hyrdklop934wcnbdyuw41asdcvn85621nmbckm");
		
		Map<String,Object> parmamap = createHebaoConfigParam(codeData,pFacOrder,hebaoConfig);
		HebaoOrderResult hebaoOrderResult = hebaoPay(parmamap);
	}
	
	public static Map<String, Object> createHebaoConfigParam(String codeData,PFacOrder pFacOrder, HebaoConfig hebaoConfig) {
		Map<String,Object> map = new HashMap<String,Object>(); 
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		 //商户会计日期（自定义）
		
		 String characterSet = HebaoBaseApI.CHARACTERSET;
		 String notifyUrl = HebaoBaseApI.NotifyUrl;
		 String merchantId = hebaoConfig.getSpNo();
		 String requestId = System.currentTimeMillis()+"";
		 String signType = HebaoBaseApI.SIGNTYPE;
		 String type = HebaoBaseApI.CLOUDQUICKPAY;
		 String version = HebaoBaseApI.VERSION;
		 
		 String amount = pFacOrder.getTotalFee().toString();
		 String currency = HebaoBaseApI.CURRENCY;
		 String orderDate = sdf.format(new Date()).substring(0, 8);
		 String orderId = System.currentTimeMillis()+"";
		 String period = HebaoBaseApI.PERIOD;
	
		 String periodUnit = HebaoBaseApI.PERIODUNIT;
		 String productName = pFacOrder.getStoreName();
		 String userToken = codeData;
		 String oprId = HebaoBaseApI.OPRID;
		
		 
			//-- 签名
			String signData =  characterSet  + notifyUrl  + merchantId  + requestId 
					+ signType  + type 	+ version  	+ amount   + currency + orderDate 
					+ orderId  + period  + periodUnit 
				    + productName   + userToken  + oprId;
			
			String signKey = hebaoConfig.getHebaoKey();
			HiiposmUtil util = new HiiposmUtil();
			String hmac = util.MD5Sign(signData, signKey);
			
			//-- 请求报文
			String buf = "characterSet=" + characterSet 
					+ "&notifyUrl=" + notifyUrl 
					+ "&merchantId=" + merchantId 
					+ "&requestId=" + requestId 
					+ "&signType=" + signType 
					+ "&type=" + type 
					+ "&version=" + version
					+ "&amount=" + amount 
					+ "&currency=" + currency 
					+ "&orderDate=" + orderDate
					+ "&orderId=" + orderId 
					+ "&period=" + period
					+ "&periodUnit=" + periodUnit 
					+ "&productName=" + productName 
					+ "&userToken=" + userToken 
					+ "&oprId=" + oprId;
			
			//-- 带上消息摘要
				buf =  buf +"&hmac=" + hmac ;
				map.put("param", buf);
				map.put("orderId", orderId);
				map.put("orderDate", orderDate);
		
				return map;
	}

	public static HebaoOrderResult hebaoPay(Map<String, Object> paramMap) {
		HebaoOrderResult hebaoOrderResult = null;
		try {
			if(null != paramMap && paramMap.size()>0 && 
					null!= paramMap.get("param") && !"".equals(paramMap.get("param"))){
				String param = paramMap.get("param").toString();
				HiiposmUtil util = new HiiposmUtil();
				String res = util.sendAndRecv(HebaoBaseApI.MicroPayUrl , param, HebaoBaseApI.CHARACTERSET);
				hebaoOrderResult = JsonUtil.parseObject(urlToJson(res),HebaoOrderResult.class);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hebaoOrderResult;
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
}
