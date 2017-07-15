package baidu;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by lhp on 2017/3/29.
 */
public class BaiFuBaoParamBase implements Serializable  {

    @JSONField(name = "sp_no")
    private String spNo;//百度钱包商户号

    @JSONField(name = "total_amount")
    private String totalAmount;//总金额，以分为单位

    @JSONField(name = "currency")
    private String currency;//币种，默认人民币

    @JSONField(name = "input_charset")
    private String inputCharset;//请求参数的字符编码

    @JSONField(name = "version")
    private String version;//接口的版本号

    @JSONField(name = "key")
    private String key;//秘钥

    @JSONField(name = "sign")
    private String sign;//签名结果

    @JSONField(name = "sign_method")
    private String signMethod;//签名方法

	/**
	 * @return the spNo
	 */
	public String getSpNo() {
		return spNo;
	}

	/**
	 * @param spNo the spNo to set
	 */
	public void setSpNo(String spNo) {
		this.spNo = spNo;
	}

	/**
	 * @return the totalAmount
	 */
	public String getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the inputCharset
	 */
	public String getInputCharset() {
		return inputCharset;
	}

	/**
	 * @param inputCharset the inputCharset to set
	 */
	public void setInputCharset(String inputCharset) {
		this.inputCharset = inputCharset;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * @param sign the sign to set
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * @return the signMethod
	 */
	public String getSignMethod() {
		return signMethod;
	}

	/**
	 * @param signMethod the signMethod to set
	 */
	public void setSignMethod(String signMethod) {
		this.signMethod = signMethod;
	}

    
}
