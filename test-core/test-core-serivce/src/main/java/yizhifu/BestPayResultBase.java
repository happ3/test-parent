package yizhifu;

import java.io.Serializable;
/**
 * 
 * @author lhp
 * 翼支付订单通知参数基类
 */
public class BestPayResultBase implements Serializable{
	private static final long serialVersionUID = 1L;
	private String success;
	private String result;
	private String errorCode;
	private String errorMsg;
	
	private BestPayScennerResult bestPayScennerResult;
	private BestPayQueryResult bestPayQueryResult;
	private BestPayRefundResult bestPayRefundResult;
	private BestPayCancleResult bestPayCancleResult;
	
	/**
	 * @return the success
	 */
	public String getSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(String success) {
		this.success = success;
	}
	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}
	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	/**
	 * @return the bestPayScennerResult
	 */
	public BestPayScennerResult getBestPayScennerResult() {
		return bestPayScennerResult;
	}
	/**
	 * @param bestPayScennerResult the bestPayScennerResult to set
	 */
	public void setBestPayScennerResult(BestPayScennerResult bestPayScennerResult) {
		this.bestPayScennerResult = bestPayScennerResult;
	}
	/**
	 * @return the bestPayQueryResult
	 */
	public BestPayQueryResult getBestPayQueryResult() {
		return bestPayQueryResult;
	}
	/**
	 * @param bestPayQueryResult the bestPayQueryResult to set
	 */
	public void setBestPayQueryResult(BestPayQueryResult bestPayQueryResult) {
		this.bestPayQueryResult = bestPayQueryResult;
	}
	/**
	 * @return the bestPayRefundResult
	 */
	public BestPayRefundResult getBestPayRefundResult() {
		return bestPayRefundResult;
	}
	/**
	 * @param bestPayRefundResult the bestPayRefundResult to set
	 */
	public void setBestPayRefundResult(BestPayRefundResult bestPayRefundResult) {
		this.bestPayRefundResult = bestPayRefundResult;
	}
	/**
	 * @return the bestPayCancleResult
	 */
	public BestPayCancleResult getBestPayCancleResult() {
		return bestPayCancleResult;
	}
	/**
	 * @param bestPayCancleResult the bestPayCancleResult to set
	 */
	public void setBestPayCancleResult(BestPayCancleResult bestPayCancleResult) {
		this.bestPayCancleResult = bestPayCancleResult;
	}
	
	
}
