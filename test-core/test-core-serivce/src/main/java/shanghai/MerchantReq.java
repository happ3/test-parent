package shanghai;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class MerchantReq implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="merchant_id")
	private String merchantId;
	
	@XmlElement(name="action")
	private String action;
	@XmlElement(name="wx_fee")
	private String wxFee;
	@XmlElement(name="zfb_fee")
	private String zfbFee;
	
	@XmlElement(name="account_type")
	private String accountType;
	
	@XmlElement(name="bank_type")
	private String bankType;
	
	@XmlElement(name="bank_name")
	private String bankName;
	
	@XmlElement(name="bank")
	private String bank;
	
	@XmlElement(name="bank_account")
	private String bankAccount;
	
	@XmlElement(name="bank_num")
	private String bankNum;
	
	@XmlElement(name="shop_name")
	private String shopName;
	
	@XmlElement(name="company_name")
	private String companyName;
	
	@XmlElement(name="contact_name")
	private String contactName;
	
	@XmlElement(name="contact_phone")
	private String contactPhone;
	
	@XmlElement(name="service_phone")
	private String servicePhone;
	
	@XmlElement(name="address")
	private String address;
	
	@XmlElement(name="nonce_str")
	private String nonceStr;
	
	@XmlElement(name="source")
	private String source;
	
	@XmlElement(name="sign")
	private String sign;
	
	
	
	/**
	 * @return the bankNum
	 */
	public String getBankNum() {
		return bankNum;
	}
	/**
	 * @param bankNum the bankNum to set
	 */
	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
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
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the wxFee
	 */
	public String getWxFee() {
		return wxFee;
	}
	/**
	 * @param wxFee the wxFee to set
	 */
	public void setWxFee(String wxFee) {
		this.wxFee = wxFee;
	}
	/**
	 * @return the zfbFee
	 */
	public String getZfbFee() {
		return zfbFee;
	}
	/**
	 * @param zfbFee the zfbFee to set
	 */
	public void setZfbFee(String zfbFee) {
		this.zfbFee = zfbFee;
	}
	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	/**
	 * @return the bankType
	 */
	public String getBankType() {
		return bankType;
	}
	/**
	 * @param bankType the bankType to set
	 */
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * @return the bank
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * @param bank the bank to set
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}
	/**
	 * @return the bankAccount
	 */
	public String getBankAccount() {
		return bankAccount;
	}
	/**
	 * @param bankAccount the bankAccount to set
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	/**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}
	/**
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the contactName
	 */
	public String getContactName() {
		return contactName;
	}
	/**
	 * @param contactName the contactName to set
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	/**
	 * @return the contactPhone
	 */
	public String getContactPhone() {
		return contactPhone;
	}
	/**
	 * @param contactPhone the contactPhone to set
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	/**
	 * @return the servicePhone
	 */
	public String getServicePhone() {
		return servicePhone;
	}
	/**
	 * @param servicePhone the servicePhone to set
	 */
	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the nonceStr
	 */
	public String getNonceStr() {
		return nonceStr;
	}
	/**
	 * @param nonceStr the nonceStr to set
	 */
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	
	
}
