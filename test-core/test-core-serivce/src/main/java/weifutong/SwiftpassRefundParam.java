package weifutong;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class SwiftpassRefundParam extends SwiftpassParamBase{
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	private String transaction_id;
	
	@XmlElement
	private String out_refund_no;
	
	@XmlElement
	private String total_fee;
	
	@XmlElement
	private String refund_fee;
	
	@XmlElement
	private String op_user_id;
	
	@XmlElement
	private String refund_channel;
	
	
	
	
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
	
	
	
	
}
