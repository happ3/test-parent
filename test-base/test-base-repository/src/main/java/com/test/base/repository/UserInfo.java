package com.test.base.repository;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author lin
 * @date 2016-8-3
 *
 */
public class UserInfo implements Serializable {
    /**  */
    private Integer id;

    /**  */
    private Integer belongType;

    /**  */
    private String belongId;

    /**  */
    private String userName;

    /**  */
    private String pwd;

    /**  */
    private String openId;

    /**  */
    private String phone;

    /**  */
    private String email;

    /**  */
    private Date created;

    /**  */
    private Date updated;

    /**  */
    private Date deleted;

    /**  */
    private Double state;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBelongType() {
        return belongType;
    }

    public void setBelongType(Integer belongType) {
        this.belongType = belongType;
    }

    public String getBelongId() {
        return belongId;
    }

    public void setBelongId(String belongId) {
        this.belongId = belongId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Double getState() {
        return state;
    }

    public void setState(Double state) {
        this.state = state;
    }
}