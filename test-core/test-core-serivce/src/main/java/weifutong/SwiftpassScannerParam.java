package weifutong;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;


@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class SwiftpassScannerParam extends SwiftpassParamBase{
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	private String groupno;
	
	@XmlElement
	private String device_info;
	
	@XmlElement
	private String body;
	
	@XmlElement
	private String attach;
	
	@XmlElement
	private String total_fee;
	
	@XmlElement
	private String mch_create_ip;
	
	@XmlElement
	private String auth_code;
	
	@XmlElement
	private String time_start;
	
	@XmlElement
	private String time_expire;
	
	@XmlElement
	private String op_user_id;
	
	@XmlElement
	private String op_shop_id;
	
	@XmlElement
	private String op_device_id;
	
	@XmlElement
	private String goods_tag;
	
	
	/**
	 * @return the groupno
	 */
	public String getGroupno() {
		return groupno;
	}
	/**
	 * @param groupno the groupno to set
	 */
	public void setGroupno(String groupno) {
		this.groupno = groupno;
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
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}
	/**
	 * @return the attach
	 */
	public String getAttach() {
		return attach;
	}
	/**
	 * @param attach the attach to set
	 */
	public void setAttach(String attach) {
		this.attach = attach;
	}
	/**
	 * @return the total_fee
	 */
	public String getTotal_fee() {
		return total_fee;
	}
	/**
	 * @param total_fee the total_fee to set
	 */
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	/**
	 * @return the mch_create_ip
	 */
	public String getMch_create_ip() {
		return mch_create_ip;
	}
	/**
	 * @param mch_create_ip the mch_create_ip to set
	 */
	public void setMch_create_ip(String mch_create_ip) {
		this.mch_create_ip = mch_create_ip;
	}
	/**
	 * @return the auth_code
	 */
	public String getAuth_code() {
		return auth_code;
	}
	/**
	 * @param auth_code the auth_code to set
	 */
	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}
	/**
	 * @return the time_start
	 */
	public String getTime_start() {
		return time_start;
	}
	/**
	 * @param time_start the time_start to set
	 */
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}
	/**
	 * @return the time_expire
	 */
	public String getTime_expire() {
		return time_expire;
	}
	/**
	 * @param time_expire the time_expire to set
	 */
	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}
	/**
	 * @return the op_user_id
	 */
	public String getOp_user_id() {
		return op_user_id;
	}
	/**
	 * @param op_user_id the op_user_id to set
	 */
	public void setOp_user_id(String op_user_id) {
		this.op_user_id = op_user_id;
	}
	/**
	 * @return the op_shop_id
	 */
	public String getOp_shop_id() {
		return op_shop_id;
	}
	/**
	 * @param op_shop_id the op_shop_id to set
	 */
	public void setOp_shop_id(String op_shop_id) {
		this.op_shop_id = op_shop_id;
	}
	/**
	 * @return the op_device_id
	 */
	public String getOp_device_id() {
		return op_device_id;
	}
	/**
	 * @param op_device_id the op_device_id to set
	 */
	public void setOp_device_id(String op_device_id) {
		this.op_device_id = op_device_id;
	}
	/**
	 * @return the goods_tag
	 */
	public String getGoods_tag() {
		return goods_tag;
	}
	/**
	 * @param goods_tag the goods_tag to set
	 */
	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}
	
	
	
}
