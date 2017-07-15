package weixin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 查询订单
 *
 * @author Administrator
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WechatOrderQuery extends WechatBaseRequest {
    private static final long serialVersionUID = 1L;
    @XmlElement(name = "transaction_id")
    private String transactionId;
    @XmlElement(name = "sub_mch_id")
    private String subMchId;
    @XmlElement(name = "sub_appid")
    private String subAppid;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getSubAppid() {
        return subAppid;
    }

    public void setSubAppid(String subAppid) {
        this.subAppid = subAppid;
    }
}
