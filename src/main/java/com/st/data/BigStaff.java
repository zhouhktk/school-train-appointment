package com.st.data;

import com.st.entity.Staff;

/**
 * 对Staff类的增强
 * @author : zhoufeng
 * @date : 2020/8/18
 */
public class BigStaff extends Staff {
    private String departName;

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

}
