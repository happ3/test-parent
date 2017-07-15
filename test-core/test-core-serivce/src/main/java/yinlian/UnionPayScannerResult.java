package yinlian;


public class UnionPayScannerResult extends UnionPayResultBase{
	private static final long serialVersionUID = 1L;
	private String txnAmt;
	private String currencyCode;
	private String reqReserved;
	private String queryId;
	
	
	
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
	 * @return the queryId
	 */
	public String getQueryId() {
		return queryId;
	}
	/**
	 * @param queryId the queryId to set
	 */
	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}
	
	
	
}
