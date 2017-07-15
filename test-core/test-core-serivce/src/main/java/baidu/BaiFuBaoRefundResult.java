package baidu;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializeFilter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by lhp on 2017/3/29.
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class BaiFuBaoRefundResult implements SerializeFilter{

    @XmlElement(name = "ret_code")
    private String retCode;

    @XmlElement(name = "ret_detail")
    private String retDetail;

    @XmlElement(name = "order_no")
    private String orderNo;

    @XmlElement(name = "sp_no")
    private String spNo;

    @XmlElement(name = "bfb_order_no")
    private String bfbOrderNo;

    @XmlElement(name = "sp_refund_no")
    private String spRefundNo;

    @XmlElement(name = "cashback_amount")
    private String cashbackAmount;

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetDetail() {
        return retDetail;
    }

    public void setRetDetail(String retDetail) {
        this.retDetail = retDetail;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getSpNo() {
        return spNo;
    }

    public void setSpNo(String spNo) {
        this.spNo = spNo;
    }

    public String getBfbOrderNo() {
        return bfbOrderNo;
    }

    public void setBfbOrderNo(String bfbOrderNo) {
        this.bfbOrderNo = bfbOrderNo;
    }

    public String getSpRefundNo() {
        return spRefundNo;
    }

    public void setSpRefundNo(String spRefundNo) {
        this.spRefundNo = spRefundNo;
    }

    public String getCashbackAmount() {
        return cashbackAmount;
    }

    public void setCashbackAmount(String cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
    }
}
