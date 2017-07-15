package shanghai;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class MerchantReturn implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@XmlElement
	private String cmb_code;
	@XmlElement
	private String cmb_message;
	@XmlElement
	private String sub_merchant;
	@XmlElement
	private String zfb_sub_id;
	
	
	
	/**
	 * @return the cmb_code
	 */
	public String getCmb_code() {
		return cmb_code;
	}
	/**
	 * @param cmb_code the cmb_code to set
	 */
	public void setCmb_code(String cmb_code) {
		this.cmb_code = cmb_code;
	}
	/**
	 * @return the cmb_message
	 */
	public String getCmb_message() {
		return cmb_message;
	}
	/**
	 * @param cmb_message the cmb_message to set
	 */
	public void setCmb_message(String cmb_message) {
		this.cmb_message = cmb_message;
	}
	/**
	 * @return the sub_merchant
	 */
	public String getSub_merchant() {
		return sub_merchant;
	}
	/**
	 * @param sub_merchant the sub_merchant to set
	 */
	public void setSub_merchant(String sub_merchant) {
		this.sub_merchant = sub_merchant;
	}
	/**
	 * @return the zfb_sub_id
	 */
	public String getZfb_sub_id() {
		return zfb_sub_id;
	}
	/**
	 * @param zfb_sub_id the zfb_sub_id to set
	 */
	public void setZfb_sub_id(String zfb_sub_id) {
		this.zfb_sub_id = zfb_sub_id;
	}


}
