package yizhifu;

/**
 * 
 * @author lhp
 * 翼支付订单查询请求参数
 */
public class BestPayQueryParam  extends BestPayParamBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String orderNo;
	private String orderReqNo;
	private String orderDate;
	
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
	
	
	
}
