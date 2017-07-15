package baidu;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by lhp on 2017/3/29.
 */
public class BaiFuBaoQueryContent extends BaiFuBaoResultBase{

    @JSONField(name = "order_no")
    private	 String orderNo;

    @JSONField(name = "sp_no")
    private	 String spNo;

    @JSONField(name = "bfb_order_no")
    private	 String bfbOrderNo;

    @JSONField(name = "mno")
    private	 String mno;

    @JSONField(name = "mname")
    private	 String mname;

    @JSONField(name = "tno")
    private	 String tno;

    @JSONField(name = "goods_name")
    private	 String goodsName;

    @JSONField(name = "create_time")
    private	 String createTime;

    @JSONField(name = "pay_time")
    private	 String payTime;

    @JSONField(name = "modify_time")
    private	 String modifyTime;

    @JSONField(name = "total_amount")
    private	 String totalAmount;

    @JSONField(name = "cash_amount")
    private	 String cashAmount;

    @JSONField(name = "mkt_amount")
    private	 String mktAmount;

    @JSONField(name = "pay_result")
    private	 String payResult;

    @JSONField(name = "version")
    private	 String version;

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

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(String cashAmount) {
        this.cashAmount = cashAmount;
    }

    public String getMktAmount() {
        return mktAmount;
    }

    public void setMktAmount(String mktAmount) {
        this.mktAmount = mktAmount;
    }

    public String getPayResult() {
        return payResult;
    }

    public void setPayResult(String payResult) {
        this.payResult = payResult;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
