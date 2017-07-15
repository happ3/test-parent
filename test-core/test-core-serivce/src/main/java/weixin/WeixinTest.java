package weixin;

public class WeixinTest {

	
	
	 private WechatPayParams getWeChatPayParams() {
	        WechatPayParams params = new WechatPayParams();

	        params.setAppid("wx87cd92d7382aa11a");
	        params.setMch_id("1335354001");
	        params.setDeviceInfo(System.currentTimeMillis()+"");
	        params.setNonce_str(System.currentTimeMillis() + "");
	        params.setBody("312312");
	        params.setOut_trade_no(System.currentTimeMillis()+"");
	        params.setTotalFee(1);
	        params.setSpbillCreateIp("8.8.8.8");
	        return params;
	    }
}
