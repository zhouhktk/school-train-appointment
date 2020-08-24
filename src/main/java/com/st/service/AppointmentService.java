package com.st.service;

import com.st.dao.AppointmentDao;
import com.st.entity.Appointment;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : zhoufeng
 * @date : 2020/8/20
 */
@Transactional(readOnly = true)
@Service("appointmentService")
public class AppointmentService {
    @Autowired
    private AppointmentDao appointmentDao;

    @Transactional(readOnly = false)
    public int deleteByNumber(String number) {
        return appointmentDao.deleteByNumber(number);
    }

    public List<Appointment> getListByRoomNumber(String roomNumber) {
        return appointmentDao.getListByRoomNumber(roomNumber);
    }

    @Transactional(readOnly = false)
    public int insert(Appointment record) {
        return appointmentDao.insert(record);
    }

    public List<Appointment> getAppListByStaffNumberPQ(String staffNumber,
                                                Integer page,
                                                Integer nums){
        return appointmentDao.getAppListByStaffNumberPQ(staffNumber, page, nums);
    }
    public int getAllAppNumsByStaffNumber(String staffNumber){
        return appointmentDao.getAllAppNumsByStaffNumber(staffNumber);
    }

    public Appointment selectByNumber(String number){
        return appointmentDao.selectByNumber(number);
    }
}
