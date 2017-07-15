package com.test.common.unit;

public class Test {
	public static void main(String[] args) {
	String str = "<xml>"+
	"<appid><![CDATA[wx44c0d203361769c7]]></appid>"+
	"<bank_type><![CDATA[CFT]]></bank_type>"+
	"<cash_fee><![CDATA[1]]></cash_fee>"+
	"<coupon_count><![CDATA[1]]></coupon_count>"+
	"<coupon_fee>19</coupon_fee>"+
	"<coupon_fee_0><![CDATA[19]]></coupon_fee_0>"+
	"<coupon_id_0><![CDATA[2000000000460763272]]></coupon_id_0>"+
	"<device_info><![CDATA[41111702000163D2]]></device_info>"+
	"<fee_type><![CDATA[CNY]]></fee_type>"+
	"<is_subscribe><![CDATA[N]]></is_subscribe>"+
	"<mch_id><![CDATA[1269310601]]></mch_id>"+
	"<nonce_str><![CDATA[1497323428767]]></nonce_str>"+
	"<openid><![CDATA[oMwoHs86VjUOW_Gcl5dMUA6SAE68]]></openid>"+
	"<out_trade_no><![CDATA[P195700483610902400]]></out_trade_no>"+
	"<result_code><![CDATA[SUCCESS]]></result_code>"+
	"<return_code><![CDATA[SUCCESS]]></return_code>"+
	"<sign><![CDATA[9A18359E80829360AD43B700CF200A64]]></sign>"+
	"<sub_mch_id><![CDATA[1455670902]]></sub_mch_id>"+
	"<time_end><![CDATA[20170613111129]]></time_end>"+
	"<total_fee>20</total_fee>"+
	"<trade_type><![CDATA[JSAPI]]></trade_type>"+
	"<transaction_id><![CDATA[4008762001201706135511826635]]></transaction_id>"+
	"</xml>";
	
	String []s = str.split("coupon_id");
	System.out.println(s.length);
	}
	
  private static int counter = 0;  
  public static int countStr(String str1, String str2) {  
    if (str1.indexOf(str2) == -1) {  
        return 0;  
    } else if (str1.indexOf(str2) != -1) {  
        counter++;  
        countStr(str1.substring(str1.indexOf(str2) +  
               str2.length()), str2);  
           return counter;  
    }  
        return 0;  
  } 
}
