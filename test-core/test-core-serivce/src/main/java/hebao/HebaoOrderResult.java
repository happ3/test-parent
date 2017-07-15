package hebao;

public class HebaoOrderResult extends HebaoBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String orderId;
	private String amount;
	private String coupAmt;
	private String vchAmt;
	private String cashAmt;
	private String reserved1;
	private String reserved2;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCoupAmt() {
		return coupAmt;
	}
	public void setCoupAmt(String coupAmt) {
		this.coupAmt = coupAmt;
	}
	public String getVchAmt() {
		return vchAmt;
	}
	public void setVchAmt(String vchAmt) {
		this.vchAmt = vchAmt;
	}
	public String getCashAmt() {
		return cashAmt;
	}
	public void setCashAmt(String cashAmt) {
		this.cashAmt = cashAmt;
	}
	public String getReserved1() {
		return reserved1;
	}
	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}
	public String getReserved2() {
		return reserved2;
	}
	public void setReserved2(String reserved2) {
		this.reserved2 = reserved2;
	}
	
	
	
}
