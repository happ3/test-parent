package yizhifu;

import java.io.Serializable;
/**
 * 
 * @author lhp
 * 翼支付请求参数基类
 */
public class BestPayParamBase implements Serializable{
	
	private static final long serialVersionUID = -7280786022912079215L;

	private String merchantId;
	private String mac;
	private String key;
	/**
	 * @return the merchantId
	 */
	public String getMerchantId() {
		return merchantId;
	}
	/**
	 * @param merchantId the merchantId to set
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	/**
	 * @return the mac
	 */
	public String getMac() {
		return mac;
	}
	/**
	 * @param mac the mac to set
	 */
	public void setMac(String mac) {
		this.mac = mac;
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
	
	
}
