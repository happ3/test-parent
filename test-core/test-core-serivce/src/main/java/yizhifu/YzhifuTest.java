package yizhifu;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.test.core.serivce.impl.MapUtil;

public class YzhifuTest {

	public static void main(String[] args) {
		
	    String merchantId = "01440109025345000";
        String orderNo = CryptTool.getCurrentDate()+"abcd";
        String orderReqNo = CryptTool.getCurrentDate()+"00001";
        String orderDate = CryptTool.getCurrentDate();
        String barcode = "510342427667103052" ;
        String orderAmt = "1";
        String keyString="23CB477D755315A3AE8D5E5559A41CAD93D85C807D295351";

        StringBuilder sb = new StringBuilder();//组装mac加密明文串
        sb.append("MERCHANTID=").append(merchantId);
        sb.append("&ORDERNO=").append(orderNo);
        sb.append("&ORDERREQNO=").append(orderReqNo);
        sb.append("&ORDERDATE=").append(orderDate);
        sb.append("&BARCODE=").append(barcode);
        sb.append("&ORDERAMT=").append(orderAmt);
        sb.append("&KEY=").append(keyString);//此处是商户的key
		
		String mac = null;
		try {
			mac = CryptTool.md5Digest(sb.toString());
			System.out.println(mac);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//进行 md5 加密(商户自己封装 MD5 加密工具类，此处只提供参考)
		

		BestPayScennerParam bestPayScennerParam = new BestPayScennerParam();
		bestPayScennerParam.setMerchantId(merchantId);
		bestPayScennerParam.setSubMerchantId(merchantId);
		bestPayScennerParam.setBarcode(barcode);
		bestPayScennerParam.setOrderNo(orderNo);
		bestPayScennerParam.setOrderReqNo(orderReqNo);
		bestPayScennerParam.setOrderDate(orderDate);
		bestPayScennerParam.setChannel("05");
		bestPayScennerParam.setBusiType("0001");
//		bestPayScennerParam.setTransType
		bestPayScennerParam.setOrderAmt(orderAmt);
		bestPayScennerParam.setProductAmt(orderAmt);
		bestPayScennerParam.setAttachAmt("0");
		bestPayScennerParam.setKey(keyString);
		bestPayScennerParam.setGoodsName("test");
		bestPayScennerParam.setStoreId("201231");
		bestPayScennerParam.setMac(mac);
		
		
	
		
		
		
	}
}
