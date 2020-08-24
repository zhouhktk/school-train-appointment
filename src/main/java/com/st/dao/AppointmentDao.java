package com.st.dao;

import com.st.entity.Appointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppointmentDao {
    int deleteByNumber(String number);

    List<Appointment> getListByRoomNumber(String roomNumber);
    int insert(Appointment record);

    List<Appointment> getAppListByStaffNumberPQ(@Param("staffNumber") String staffNumber,
                                              @Param("page") Integer page,
                                              @Param("nums") Integer nums);
    int getAllAppNumsByStaffNumber(String staffNumber);

    Appointment selectByNumber(String number);

}