package hebao;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author lin
 * @date 2016-10-29
 *
 */
public class PFacOrder implements Serializable {
    /** 主键id */
    private Integer id;

    /** 订单编号-主扫 */
    private String orderNo;

    /** 订单编号-被扫 */
    private String orderNos;

    /** 统一订单编号 */
    private String uOrderNo;

    /** 收银台id */
    private Integer cashierId;

    /** 收银台编号 */
    private String cashierNo;

    /** 设备id */
    private Integer deviceId;

    /** 设备编号 */
    private String deviceNumber;

    /** 门店id */
    private Integer storeId;

    /** 门店名称 */
    private String storeName;

    /** 商户id */
    private Integer merchantId;

    /** 代理商id */
    private Integer agentId;

    /** 标题 */
    private String title;

    /** 订单类型（1.被扫支付 2.扫码支付） */
    private Integer orderType;

    /** 订单金额(单位/分) */
    private Integer totalFee;

    /** 订单描述信息 */
    private String body;

    /** 创建订单的平台(alipay,wechat) */
    private String createPlatform;

    /** 支付平台[1.alipay | 2.wechat] */
    private Integer payPlatfrom;

    /** 支付平台订单号 */
    private String payPlatfromNo;

    /** 支付状态[1,未支付 | 2,已支付 | 3,已支付有退款] */
    private Integer orderState;

    /** 退款金额(默认值0,单位/分) */
    private Integer refundFee;

    /** 创建时间 */
    private Date created;

    /** 更新时间 */
    private Date updated;

    /** 优惠金额 */
    private Integer reduceFee;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderNos() {
        return orderNos;
    }

    public void setOrderNos(String orderNos) {
        this.orderNos = orderNos;
    }

    public String getuOrderNo() {
        return uOrderNo;
    }

    public void setuOrderNo(String uOrderNo) {
        this.uOrderNo = uOrderNo;
    }

    public Integer getCashierId() {
        return cashierId;
    }

    public void setCashierId(Integer cashierId) {
        this.cashierId = cashierId;
    }

    public String getCashierNo() {
        return cashierNo;
    }

    public void setCashierNo(String cashierNo) {
        this.cashierNo = cashierNo;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreatePlatform() {
        return createPlatform;
    }

    public void setCreatePlatform(String createPlatform) {
        this.createPlatform = createPlatform;
    }

    public Integer getPayPlatfrom() {
        return payPlatfrom;
    }

    public void setPayPlatfrom(Integer payPlatfrom) {
        this.payPlatfrom = payPlatfrom;
    }

    public String getPayPlatfromNo() {
        return payPlatfromNo;
    }

    public void setPayPlatfromNo(String payPlatfromNo) {
        this.payPlatfromNo = payPlatfromNo;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Integer getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Integer refundFee) {
        this.refundFee = refundFee;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Integer getReduceFee() {
        return reduceFee;
    }

    public void setReduceFee(Integer reduceFee) {
        this.reduceFee = reduceFee;
    }
}