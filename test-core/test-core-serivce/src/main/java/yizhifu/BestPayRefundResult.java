package yizhifu;

import java.io.Serializable;

/**
 * 
 * @author lhp
 * 翼支付退款通知返回参数
 */
public class BestPayRefundResult implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String sign;
	private String refundReqNo;
	private String oldOrderNo;
	private String transAmt;
	
	
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
	 * @return the refundReqNo
	 */
	public String getRefundReqNo() {
		return refundReqNo;
	}
	/**
	 * @param refundReqNo the refundReqNo to set
	 */
	public void setRefundReqNo(String refundReqNo) {
		this.refundReqNo = refundReqNo;
	}
	/**
	 * @return the oldOrderNo
	 */
	public String getOldOrderNo() {
		return oldOrderNo;
	}
	/**
	 * @param oldOrderNo the oldOrderNo to set
	 */
	public void setOldOrderNo(String oldOrderNo) {
		this.oldOrderNo = oldOrderNo;
	}
	/**
	 * @return the transAmt
	 */
	public String getTransAmt() {
		return transAmt;
	}
	/**
	 * @param transAmt the transAmt to set
	 */
	public void setTransAmt(String transAmt) {
		this.transAmt = transAmt;
	}
	
	
}
