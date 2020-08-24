package com.st.entity;

import java.io.Serializable;

/**
 * 会议室
 * room
 * @author 
 */
public class Room implements Serializable {
    private Integer id;

    private String number;

    private String staffNumber;//负责人编号

    private String image;

    private Integer restTimes;

    private Integer hot;

    private Integer status;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", staffNumber='" + staffNumber + '\'' +
                ", image='" + image + '\'' +
                ", restTimes=" + restTimes +
                ", hot=" + hot +
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

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getRestTimes() {
        return restTimes;
    }

    public void setRestTimes(Integer restTimes) {
        this.restTimes = restTimes;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }
}