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
public class HebaoConfig implements Serializable {
    /** 主键id */
    private Integer id;

    /** 所属商户ID */
    private Integer merchantId;

    /** 配置名称 */
    private String configName;

    /** 和包商户号 */
    private String spNo;

    /** 秘钥 */
    private String hebaoKey;

    /** 创建时间 */
    private Date created;

    /** 更新时间 */
    private Date updated;

    /** 删除时间 */
    private Date deleted;

    /** 状态[0,正常|1,删除] */
    private Integer state;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getSpNo() {
        return spNo;
    }

    public void setSpNo(String spNo) {
        this.spNo = spNo;
    }

    public String getHebaoKey() {
        return hebaoKey;
    }

    public void setHebaoKey(String hebaoKey) {
        this.hebaoKey = hebaoKey;
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

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}