package weifutong;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author lhp
 *
 */

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class SwiftpassQueryResult extends SwiftpassParamBase{
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	private String transaction_id;
	
	@XmlElement
	private String out_trade_no;
	
	@XmlElement
	private String out_refund_no;
	
	@XmlElement
	private String refund_id;
	
	@XmlElement
	private String refund_channel;
	
	@XmlElement
	private String refund_fee;
	
	@XmlElement
	private String coupon_refund_fee;
	
	
	
	
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
	 * @return the out_refund_no
	 */
	public String getOut_refund_no() {
		return out_refund_no;
	}
	/**
	 * @param out_refund_no the out_refund_no to set
	 */
	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}
	/**
	 * @return the refund_id
	 */
	public String getRefund_id() {
		return refund_id;
	}
	/**
	 * @param refund_id the refund_id to set
	 */
	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}
	/**
	 * @return the refund_channel
	 */
	public String getRefund_channel() {
		return refund_channel;
	}
	/**
	 * @param refund_channel the refund_channel to set
	 */
	public void setRefund_channel(String refund_channel) {
		this.refund_channel = refund_channel;
	}
	/**
	 * @return the refund_fee
	 */
	public String getRefund_fee() {
		return refund_fee;
	}
	/**
	 * @param refund_fee the refund_fee to set
	 */
	public void setRefund_fee(String refund_fee) {
		this.refund_fee = refund_fee;
	}
	/**
	 * @return the coupon_refund_fee
	 */
	public String getCoupon_refund_fee() {
		return coupon_refund_fee;
	}
	/**
	 * @param coupon_refund_fee the coupon_refund_fee to set
	 */
	public void setCoupon_refund_fee(String coupon_refund_fee) {
		this.coupon_refund_fee = coupon_refund_fee;
	}
	
	
	
}
