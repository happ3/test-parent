package weifutong;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class SwiftpassScannerResult extends SwiftpassResultBase{
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	private String openid;
	
	@XmlElement
	private String trade_type;
	
	@XmlElement
	private String is_subscribe;
	
	@XmlElement
	private String pay_result;
	
	@XmlElement
	private String pay_info;
	
	@XmlElement
	private String transaction_id;
	
	@XmlElement
	private String out_transaction_id;
	
	@XmlElement
	private String sub_is_subscribe;
	
	@XmlElement
	private String sub_appid;
	
	@XmlElement
	private String out_trade_no;
	
	@XmlElement
	private String total_fee;
	
	@XmlElement
	private String coupon_fee;
	
	@XmlElement
	private String fee_type;
	
	@XmlElement
	private String attach;
	
	@XmlElement
	private String bank_type;
	
	@XmlElement
	private String bank_billno;
	
	@XmlElement
	private String time_end;
	
	/**
	 * @return the openid
	 */
	public String getOpenid() {
		return openid;
	}
	/**
	 * @param openid the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	 * @return the trade_type
	 */
	public String getTrade_type() {
		return trade_type;
	}
	/**
	 * @param trade_type the trade_type to set
	 */
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	/**
	 * @return the is_subscribe
	 */
	public String getIs_subscribe() {
		return is_subscribe;
	}
	/**
	 * @param is_subscribe the is_subscribe to set
	 */
	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}
	/**
	 * @return the pay_result
	 */
	public String getPay_result() {
		return pay_result;
	}
	/**
	 * @param pay_result the pay_result to set
	 */
	public void setPay_result(String pay_result) {
		this.pay_result = pay_result;
	}
	/**
	 * @return the pay_info
	 */
	public String getPay_info() {
		return pay_info;
	}
	/**
	 * @param pay_info the pay_info to set
	 */
	public void setPay_info(String pay_info) {
		this.pay_info = pay_info;
	}
	/**
	 * @return the transaction_id
	 */
	public String getTransaction_id() {
		return transaction_id;
	}
	/**
	 * @param transaction_id the transaction_id to set
	 */
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	/**
	 * @return the out_transaction_id
	 */
	public String getOut_transaction_id() {
		return out_transaction_id;
	}
	/**
	 * @param out_transaction_id the out_transaction_id to set
	 */
	public void setOut_transaction_id(String out_transaction_id) {
		this.out_transaction_id = out_transaction_id;
	}
	/**
	 * @return the sub_is_subscribe
	 */
	public String getSub_is_subscribe() {
		return sub_is_subscribe;
	}
	/**
	 * @param sub_is_subscribe the sub_is_subscribe to set
	 */
	public void setSub_is_subscribe(String sub_is_subscribe) {
		this.sub_is_subscribe = sub_is_subscribe;
	}
	/**
	 * @return the sub_appid
	 */
	public String getSub_appid() {
		return sub_appid;
	}
	/**
	 * @param sub_appid the sub_appid to set
	 */
	public void setSub_appid(String sub_appid) {
		this.sub_appid = sub_appid;
	}
	/**
	 * @return the out_trade_no
	 */
	public String getOut_trade_no() {
		return out_trade_no;
	}
	/**
	 * @param out_trade_no the out_trade_no to set
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
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
	 * @return the coupon_fee
	 */
	public String getCoupon_fee() {
		return coupon_fee;
	}
	/**
	 * @param coupon_fee the coupon_fee to set
	 */
	public void setCoupon_fee(String coupon_fee) {
		this.coupon_fee = coupon_fee;
	}
	/**
	 * @return the fee_type
	 */
	public String getFee_type() {
		return fee_type;
	}
	/**
	 * @param fee_type the fee_type to set
	 */
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
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
	 * @return the bank_type
	 */
	public String getBank_type() {
		return bank_type;
	}
	/**
	 * @param bank_type the bank_type to set
	 */
	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}
	/**
	 * @return the bank_billno
	 */
	public String getBank_billno() {
		return bank_billno;
	}
	/**
	 * @param bank_billno the bank_billno to set
	 */
	public void setBank_billno(String bank_billno) {
		this.bank_billno = bank_billno;
	}
	/**
	 * @return the time_end
	 */
	public String getTime_end() {
		return time_end;
	}
	/**
	 * @param time_end the time_end to set
	 */
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
	
	
	
	
}
