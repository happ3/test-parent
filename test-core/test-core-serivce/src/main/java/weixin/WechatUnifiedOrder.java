package weixin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 统一支付请求参数
 */

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WechatUnifiedOrder extends WechatBaseRequest {
    @XmlElement(name = "device_info")
    private String deviceInfo;
    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String body;
    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String attach;
    @XmlElement(name = "total_fee")
    private String totalFee;
    @XmlElement(name = "spbill_create_ip")
    private String spbillCreateIp;
    @XmlElement(name = "time_start")
    private String timeStart;
    @XmlElement(name = "time_expire")
    private String timeExpire;
    @XmlElement(name = "goods_tag")
    private String goodsTag;
    @XmlElement(name = "notify_url")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String notifyUrl;
    @XmlElement(name = "trade_type")
    private String tradeType;
    @XmlElement
    private String openid;
    @XmlElement(name = "product_id")
    private String productId;
    //子商户公众账号ID
    @XmlElement(name = "sub_appid")
    private String subAppid;
    //子商户号
    @XmlElement(name = "sub_mch_id")
    private String subMchId;

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
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

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSubAppid() {
        return subAppid;
    }

    public void setSubAppid(String subAppid) {
        this.subAppid = subAppid;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    @Override
    public String toString() {
        return "WXUnifiedOrder [device_info=" + deviceInfo + ", body=" + body + ", attach=" + attach + ", total_fee="
                + totalFee + ", spbill_create_ip=" + spbillCreateIp + ", time_start=" + timeStart + ", time_expire="
                + timeExpire + ", goods_tag=" + goodsTag + ", notify_url=" + notifyUrl + ", trade_type=" + tradeType
                + ", openid=" + openid + ", product_id=" + productId + "]";
    }
}
