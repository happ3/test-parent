package yizhifu;

/**
 * 
 * @author lhp
 * 翼支付退款请求参数
 */
public class BestPayRefundParam  extends BestPayParamBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String subMerchantId;
	private String merchantPwd;
	private String oldOrderNo;
	private String oldOrderReqNo;
	private String refundReqNo;
	private String refundReqDate;
	private String transAmt;
	private String ledgerDetail;
	private String channel;
	private String bgUrl;
	/**
	 * @return the subMerchantId
	 */
	public String getSubMerchantId() {
		return subMerchantId;
	}
	/**
	 * @param subMerchantId the subMerchantId to set
	 */
	public void setSubMerchantId(String subMerchantId) {
		this.subMerchantId = subMerchantId;
	}
	/**
	 * @return the merchantPwd
	 */
	public String getMerchantPwd() {
		return merchantPwd;
	}
	/**
	 * @param merchantPwd the merchantPwd to set
	 */
	public void setMerchantPwd(String merchantPwd) {
		this.merchantPwd = merchantPwd;
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
	 * @return the oldOrderReqNo
	 */
	public String getOldOrderReqNo() {
		return oldOrderReqNo;
	}
	/**
	 * @param oldOrderReqNo the oldOrderReqNo to set
	 */
	public void setOldOrderReqNo(String oldOrderReqNo) {
		this.oldOrderReqNo = oldOrderReqNo;
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
	 * @return the refundReqDate
	 */
	public String getRefundReqDate() {
		return refundReqDate;
	}
	/**
	 * @param refundReqDate the refundReqDate to set
	 */
	public void setRefundReqDate(String refundReqDate) {
		this.refundReqDate = refundReqDate;
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
	 * @return the ledgerDetail
	 */
	public String getLedgerDetail() {
		return ledgerDetail;
	}
	/**
	 * @param ledgerDetail the ledgerDetail to set
	 */
	public void setLedgerDetail(String ledgerDetail) {
		this.ledgerDetail = ledgerDetail;
	}
	/**
	 * @return the channel
	 */
	public String getChannel() {
		return channel;
	}
	/**
	 * @param channel the channel to set
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}
	/**
	 * @return the bgUrl
	 */
	public String getBgUrl() {
		return bgUrl;
	}
	/**
	 * @param bgUrl the bgUrl to set
	 */
	public void setBgUrl(String bgUrl) {
		this.bgUrl = bgUrl;
	}
	
	
	
}
