package com.st.dao;

import com.st.entity.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffDao {

    Staff selectByNumber(String number);

    int update(Staff record);

    List<Staff> getAll();

}