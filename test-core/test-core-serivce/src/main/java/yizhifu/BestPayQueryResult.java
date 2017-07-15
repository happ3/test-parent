package yizhifu;

import java.io.Serializable;

/**
 * 
 * @author lhp
 * 翼支付查询订单通知参数
 */
public class BestPayQueryResult implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String merchantId;
	private String orderNo;
	private String orderReqNo;
	private String orderDate;
	private String ourTransNo;
	private String transAmt;
	private String transStatus;
	private String encodeType;
	private String sign;
	private String coupon;
	private String scValue;
	private String payerAccount;
	private String payeeAccount;
	private String payChannel;
	private String productDesc;
	private String refundFlag;
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
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * @return the orderReqNo
	 */
	public String getOrderReqNo() {
		return orderReqNo;
	}
	/**
	 * @param orderReqNo the orderReqNo to set
	 */
	public void setOrderReqNo(String orderReqNo) {
		this.orderReqNo = orderReqNo;
	}
	/**
	 * @return the orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * @return the ourTransNo
	 */
	public String getOurTransNo() {
		return ourTransNo;
	}
	/**
	 * @param ourTransNo the ourTransNo to set
	 */
	public void setOurTransNo(String ourTransNo) {
		this.ourTransNo = ourTransNo;
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
	/**
	 * @return the transStatus
	 */
	public String getTransStatus() {
		return transStatus;
	}
	/**
	 * @param transStatus the transStatus to set
	 */
	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}
	/**
	 * @return the encodeType
	 */
	public String getEncodeType() {
		return encodeType;
	}
	/**
	 * @param encodeType the encodeType to set
	 */
	public void setEncodeType(String encodeType) {
		this.encodeType = encodeType;
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
	 * @return the coupon
	 */
	public String getCoupon() {
		return coupon;
	}
	/**
	 * @param coupon the coupon to set
	 */
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	/**
	 * @return the scValue
	 */
	public String getScValue() {
		return scValue;
	}
	/**
	 * @param scValue the scValue to set
	 */
	public void setScValue(String scValue) {
		this.scValue = scValue;
	}
	/**
	 * @return the payerAccount
	 */
	public String getPayerAccount() {
		return payerAccount;
	}
	/**
	 * @param payerAccount the payerAccount to set
	 */
	public void setPayerAccount(String payerAccount) {
		this.payerAccount = payerAccount;
	}
	/**
	 * @return the payeeAccount
	 */
	public String getPayeeAccount() {
		return payeeAccount;
	}
	/**
	 * @param payeeAccount the payeeAccount to set
	 */
	public void setPayeeAccount(String payeeAccount) {
		this.payeeAccount = payeeAccount;
	}
	/**
	 * @return the payChannel
	 */
	public String getPayChannel() {
		return payChannel;
	}
	/**
	 * @param payChannel the payChannel to set
	 */
	public void setPayChannel(String payChannel) {
		this.payChannel = payChannel;
	}
	/**
	 * @return the productDesc
	 */
	public String getProductDesc() {
		return productDesc;
	}
	/**
	 * @param productDesc the productDesc to set
	 */
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	/**
	 * @return the refundFlag
	 */
	public String getRefundFlag() {
		return refundFlag;
	}
	/**
	 * @param refundFlag the refundFlag to set
	 */
	public void setRefundFlag(String refundFlag) {
		this.refundFlag = refundFlag;
	}

	
}
