package com.st.service;

import com.st.dao.DepartmentDao;
import com.st.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : zhoufeng
 * @date : 2020/8/18
 */
@Transactional(readOnly = true)
@Service("departmentService")
public class DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    public Department selectByNumber(String number){
        return departmentDao.selectByNumber(number);
    }


}
