package baidu;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;

public class BaiFuBaoConstants {

    protected static Header jsonHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.APPLICATION_JSON.toString());

    public static final String UnifiedorderURL= "https://www.baifubao.com/o2o/0/code/0/create/0";
    public static final String MCH_MICRO_PAY= "https://www.baifubao.com/o2o/0/b2c/0/api/0/pay/0";
    public static final String QueryUrl= "https://www.baifubao.com/o2o/0/b2c/0/api/0/query_trans/0";
    public static final String NotifyUrl= "http://yirui.2dupay.com/baiduNotify";


    public static final String CURRENCY ="1";
    public static final String PAYTYPE ="1";
    public static final String SERVICE_CODE ="1";
    public static final String SIGN_METHOD ="1";
    public static final String INPUT_CHARSET ="1";
    public static final String VERSION ="2";
    public static final String OUTPUT_TYPE ="1";
}
