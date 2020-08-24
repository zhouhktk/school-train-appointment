package com.st.dao;

import com.st.entity.Department;


public interface DepartmentDao {

    Department selectByNumber(String number);

}