package hebao;



public class HebaoBaseApI {
	
    /**接口名称*/
    public static final String UnifiedorderURL= "https://ipos.10086.cn/ips/cmpayService";
    public static final String MicroPayUrl= "https://ipos.10086.cn/cps/cmpayService";
    
    public static final String QueryUrl= "https://ipos.10086.cn/cps/cmpayService";
    
    public static final String NotifyUrl= "http://yirui.2dupay.com/hebaoNotify";
    
    
    public static final String CHARACTERSET ="00";
    public static final String SIGNTYPE ="MD5";
    public static final String IPADDRESS ="192.168.59.101";
    public static final String VERSION ="2.0.0";
    public static final String CURRENCY ="00";
    public static final String PERIOD ="30";
    public static final String PERIODUNIT ="00";
    public static final String COUPONSFLAG ="00";
    public static final String CASDIRECTPAYCONFIRM ="CASDirectPayConfirm";
    public static final String CLOUDQUICKPAY = "CloudQuickPay";
    public static final String Url ="http://agent.2dupay.com";
    public static final String PayUrl ="https://p.10086.cn/info/wap/qrcodepay/downloadclient.html?SESSIONID=";
    public static final String SUCCESS ="000000";
    public static final String PAYSUCCESS ="支付完成";
	public static final String OPRID = "00";
	public static final String ORDERQUERYBYYPOS = "OrderQueryByYPOS";
	public static final Object TOPAY = "PCC00225";//条码支付额度超限
    
    
    public static  String getTel() {  
        String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");  
            int index=getNum(0,telFirst.length-1);  
            String first=telFirst[index];  
            String second=String.valueOf(getNum(1,888)+10000).substring(1);  
            String thrid=String.valueOf(getNum(1,9100)+10000).substring(1);  
			return first+second+thrid;   
	}
    public static int getNum(int start,int end) {  
        return (int)(Math.random()*(end-start+1)+start);  
    }  
}