package yinlian;

/**
 * 银联支付被扫请求参数
 * @author lhp
 *
 */
public class UnionPayScannerParam extends UnionPayParamBase {
	private static final long serialVersionUID = 1L;
		private String channelType;
		private String backUrl;	
	private String merCatCode;
	private String merName;
	private String merAbbr;
		private String qrNo;
	private String subMerId;
	private String subMerName;
	private String subMerAbbr;
		private String txnTime;
		private String txnAmt;
		private String currencyCode;
	private String termId;
	private String reqReserved;
	private String riskRateInfo;
	
	
	/**
	 * @return the channelType
	 */
	public String getChannelType() {
		return channelType;
	}
	/**
	 * @param channelType the channelType to set
	 */
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	/**
	 * @return the backUrl
	 */
	public String getBackUrl() {
		return backUrl;
	}
	/**
	 * @param backUrl the backUrl to set
	 */
	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}
	/**
	 * @return the merCatCode
	 */
	public String getMerCatCode() {
		return merCatCode;
	}
	/**
	 * @param merCatCode the merCatCode to set
	 */
	public void setMerCatCode(String merCatCode) {
		this.merCatCode = merCatCode;
	}
	/**
	 * @return the merName
	 */
	public String getMerName() {
		return merName;
	}
	/**
	 * @param merName the merName to set
	 */
	public void setMerName(String merName) {
		this.merName = merName;
	}
	/**
	 * @return the merAbbr
	 */
	public String getMerAbbr() {
		return merAbbr;
	}
	/**
	 * @param merAbbr the merAbbr to set
	 */
	public void setMerAbbr(String merAbbr) {
		this.merAbbr = merAbbr;
	}
	/**
	 * @return the qrNo
	 */
	public String getQrNo() {
		return qrNo;
	}
	/**
	 * @param qrNo the qrNo to set
	 */
	public void setQrNo(String qrNo) {
		this.qrNo = qrNo;
	}
	/**
	 * @return the subMerId
	 */
	public String getSubMerId() {
		return subMerId;
	}
	/**
	 * @param subMerId the subMerId to set
	 */
	public void setSubMerId(String subMerId) {
		this.subMerId = subMerId;
	}
	/**
	 * @return the subMerName
	 */
	public String getSubMerName() {
		return subMerName;
	}
	/**
	 * @param subMerName the subMerName to set
	 */
	public void setSubMerName(String subMerName) {
		this.subMerName = subMerName;
	}
	/**
	 * @return the subMerAbbr
	 */
	public String getSubMerAbbr() {
		return subMerAbbr;
	}
	/**
	 * @param subMerAbbr the subMerAbbr to set
	 */
	public void setSubMerAbbr(String subMerAbbr) {
		this.subMerAbbr = subMerAbbr;
	}
	/**
	 * @return the txnTime
	 */
	public String getTxnTime() {
		return txnTime;
	}
	/**
	 * @param txnTime the txnTime to set
	 */
	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}
	/**
	 * @return the txnAmt
	 */
	public String getTxnAmt() {
		return txnAmt;
	}
	/**
	 * @param txnAmt the txnAmt to set
	 */
	public void setTxnAmt(String txnAmt) {
		this.txnAmt = txnAmt;
	}
	/**
	 * @return the currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}
	/**
	 * @param currencyCode the currencyCode to set
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	/**
	 * @return the termId
	 */
	public String getTermId() {
		return termId;
	}
	/**
	 * @param termId the termId to set
	 */
	public void setTermId(String termId) {
		this.termId = termId;
	}
	/**
	 * @return the reqReserved
	 */
	public String getReqReserved() {
		return reqReserved;
	}
	/**
	 * @param reqReserved the reqReserved to set
	 */
	public void setReqReserved(String reqReserved) {
		this.reqReserved = reqReserved;
	}
	/**
	 * @return the riskRateInfo
	 */
	public String getRiskRateInfo() {
		return riskRateInfo;
	}
	/**
	 * @param riskRateInfo the riskRateInfo to set
	 */
	public void setRiskRateInfo(String riskRateInfo) {
		this.riskRateInfo = riskRateInfo;
	}
	
	
}
