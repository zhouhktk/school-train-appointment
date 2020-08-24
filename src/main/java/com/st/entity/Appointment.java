package com.st.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * appointment
 * @author 
 */
public class Appointment implements Serializable {
    private Integer id;

    private String staffNumber;

    private String roomNumber;

    private String number;

    private Integer status;

    private String desc;

    private Date startTime;

    private Date endTime;

    private Date createTime;

    private Date updateTime;

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", staffNumber='" + staffNumber + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", number='" + number + '\'' +
                ", status=" + status +
                ", desc='" + desc + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}