package weifutong;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

public class SwiftpassResultBase implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String version;
	
	private String charset;
	
	private String sign_type;
	
	private String status;
	
	private String message;
	
	private String result_code;
	
	private String mch_id;
	
	private String device_info;
	
	private String nonce_str;
	
	private String err_code;
	
	private String err_msg;
	
	private String sign;
	
	private String need_query;
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
	 * @return the charset
	 */
	public String getCharset() {
		return charset;
	}
	/**
	 * @param charset the charset to set
	 */
	public void setCharset(String charset) {
		this.charset = charset;
	}
	/**
	 * @return the sign_type
	 */
	public String getSign_type() {
		return sign_type;
	}
	/**
	 * @param sign_type the sign_type to set
	 */
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the result_code
	 */
	public String getResult_code() {
		return result_code;
	}
	/**
	 * @param result_code the result_code to set
	 */
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	/**
	 * @return the mch_id
	 */
	public String getMch_id() {
		return mch_id;
	}
	/**
	 * @param mch_id the mch_id to set
	 */
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	/**
	 * @return the device_info
	 */
	public String getDevice_info() {
		return device_info;
	}
	/**
	 * @param device_info the device_info to set
	 */
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	/**
	 * @return the nonce_str
	 */
	public String getNonce_str() {
		return nonce_str;
	}
	/**
	 * @param nonce_str the nonce_str to set
	 */
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	/**
	 * @return the err_code
	 */
	public String getErr_code() {
		return err_code;
	}
	/**
	 * @param err_code the err_code to set
	 */
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	/**
	 * @return the err_msg
	 */
	public String getErr_msg() {
		return err_msg;
	}
	/**
	 * @param err_msg the err_msg to set
	 */
	public void setErr_msg(String err_msg) {
		this.err_msg = err_msg;
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
	 * @return the need_query
	 */
	public String getNeed_query() {
		return need_query;
	}
	/**
	 * @param need_query the need_query to set
	 */
	public void setNeed_query(String need_query) {
		this.need_query = need_query;
	}
	
	
}
