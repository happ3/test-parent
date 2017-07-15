package weixin;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 统一支付请求返回对象
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WechatUnifiedOrderResult extends WechatBase {
    @XmlElement(name = "device_info")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String deviceInfo;
    @XmlElement(name = "trade_type")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String tradeType;
    @XmlElement(name = "prepay_id")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String prepayId;
    @XmlElement(name = "code_url")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String codeUrl;
    @XmlElement(name = "sub_appid")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String subAppid;
    @XmlElement(name = "sub_mch_id")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String subMchId;

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
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


}
