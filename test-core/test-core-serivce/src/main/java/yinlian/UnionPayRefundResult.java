package yinlian;

import java.io.Serializable;

public class UnionPayRefundResult implements Serializable{
	private static final long serialVersionUID = 1L;
	private String origQryId;
	private String origOrderId;
	private String origTxnTime;
	private String txnAmt;
	private String reqReserved;
	private String queryId;
	
	/**
	 * @return the origQryId
	 */
	public String getOrigQryId() {
		return origQryId;
	}
	/**
	 * @param origQryId the origQryId to set
	 */
	public void setOrigQryId(String origQryId) {
		this.origQryId = origQryId;
	}
	/**
	 * @return the origOrderId
	 */
	public String getOrigOrderId() {
		return origOrderId;
	}
	/**
	 * @param origOrderId the origOrderId to set
	 */
	public void setOrigOrderId(String origOrderId) {
		this.origOrderId = origOrderId;
	}
	/**
	 * @return the origTxnTime
	 */
	public String getOrigTxnTime() {
		return origTxnTime;
	}
	/**
	 * @param origTxnTime the origTxnTime to set
	 */
	public void setOrigTxnTime(String origTxnTime) {
		this.origTxnTime = origTxnTime;
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
