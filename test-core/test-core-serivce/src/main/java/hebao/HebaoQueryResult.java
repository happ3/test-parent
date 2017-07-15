package hebao;

public class HebaoQueryResult extends HebaoBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String orderId;
	private String merchantName;
	private String mblNo;
	private String ordSts;
	private String payDate;
	private String amount;
	private String cashAmount;
	private String bonAmount;
	private String splAmount;
	private String vchAmount;
	private String merOprNo;
	private String storeId;
	private String posId;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getMblNo() {
		return mblNo;
	}
	public void setMblNo(String mblNo) {
		this.mblNo = mblNo;
	}
	public String getOrdSts() {
		return ordSts;
	}
	public void setOrdSts(String ordSts) {
		this.ordSts = ordSts;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCashAmount() {
		return cashAmount;
	}
	public void setCashAmount(String cashAmount) {
		this.cashAmount = cashAmount;
	}
	public String getBonAmount() {
		return bonAmount;
	}
	public void setBonAmount(String bonAmount) {
		this.bonAmount = bonAmount;
	}
	public String getSplAmount() {
		return splAmount;
	}
	public void setSplAmount(String splAmount) {
		this.splAmount = splAmount;
	}
	public String getVchAmount() {
		return vchAmount;
	}
	public void setVchAmount(String vchAmount) {
		this.vchAmount = vchAmount;
	}
	public String getMerOprNo() {
		return merOprNo;
	}
	public void setMerOprNo(String merOprNo) {
		this.merOprNo = merOprNo;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getPosId() {
		return posId;
	}
	public void setPosId(String posId) {
		this.posId = posId;
	}

	
}
