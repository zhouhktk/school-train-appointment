package com.st.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 部门名称
 * department
 * @author 
 */
public class Department implements Serializable {
    private Integer id;

    private String number;

    private String departName;

    private String desc;

    private Date updateTime;

    private Date createTime;
    private Integer status;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", departName='" + departName + '\'' +
                ", desc='" + desc + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", status=" + status +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}