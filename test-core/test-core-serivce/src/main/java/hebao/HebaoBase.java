package hebao;

import java.io.Serializable;

public class HebaoBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String  merchantId;
	private String  requestId;
	private String  signType;
	private String  type;
	private String  version;
	private String  returnCode;
	private String  message;
	private String  serverCert;
	private String  hmac;
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getServerCert() {
		return serverCert;
	}
	public void setServerCert(String serverCert) {
		this.serverCert = serverCert;
	}
	public String getHmac() {
		return hmac;
	}
	public void setHmac(String hmac) {
		this.hmac = hmac;
	}
	
	
}
