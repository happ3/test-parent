package baidu;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 统一支付请求参数
 *
 */

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WXUnifiedOrder{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement
	private String device_info;

	@XmlElement
	private String body;

	@XmlElement
	private String attach;

	@XmlElement
	private String total_fee;

	@XmlElement
	private String spbill_create_ip;

	@XmlElement
	private String time_start;

	@XmlElement
	private String time_expire;

	@XmlElement
	private String goods_tag;

	@XmlElement
	private String notify_url;

	@XmlElement
	private String trade_type;

	@XmlElement
	private String openid;

	@XmlElement
	private String product_id;
	
	//子商户公众账号ID
	@XmlElement
	private String sub_appid;
	//子商户号
	@XmlElement
	private String sub_mch_id;
		


	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getSub_appid() {
		return sub_appid;
	}

	public void setSub_appid(String sub_appid) {
		this.sub_appid = sub_appid;
	}

	public String getSub_mch_id() {
		return sub_mch_id;
	}

	public void setSub_mch_id(String sub_mch_id) {
		this.sub_mch_id = sub_mch_id;
	}

	@Override
	public String toString() {
		return "WXUnifiedOrder [device_info=" + device_info + ", body=" + body + ", attach=" + attach + ", total_fee="
				+ total_fee + ", spbill_create_ip=" + spbill_create_ip + ", time_start=" + time_start + ", time_expire="
				+ time_expire + ", goods_tag=" + goods_tag + ", notify_url=" + notify_url + ", trade_type=" + trade_type
				+ ", openid=" + openid + ", product_id=" + product_id + "]";
	}
}
