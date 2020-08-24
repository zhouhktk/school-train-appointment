package com.st.controller;

import com.st.data.Code;
import com.st.data.ResponseVo;
import com.st.entity.Appointment;
import com.st.entity.Room;
import com.st.entity.Staff;
import com.st.service.AppointmentService;
import com.st.service.RoomService;
import com.st.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author : zhoufeng
 * @date : 2020/8/20
 */
@RestController
@RequestMapping("/app")
@Scope("session")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private RoomService roomService;


    /**
     * 根据房间编号查寻所有对应的预约项
     *
     * @param roomNumber
     * @return
     */
    @GetMapping("/getlistbyroom")
    public ResponseVo getListByRoomNumber(@RequestParam(value = "roomNumber", defaultValue = "") String roomNumber) {
        if ("".equals(roomNumber)) {
            return new ResponseVo(Code.FAILED, "查寻预约项失败", null);
        }
        List<Appointment> appList = appointmentService.getListByRoomNumber(roomNumber);
        HashMap<String, Object> map = new HashMap<>();
        map.put("appList", appList);
        map.put("count", appList.size());
        if (appList.size() > 0) {
            return new ResponseVo(Code.SUCCESS, "查询预约信息列表成功！", map);
        } else {
            return new ResponseVo(Code.SUCCESS, "查询预约信息列表失败！", map);
        }

    }


    /**
     * 生成新的预约信息
     *
     * @param appointment
     * @return
     */
    @PostMapping("/insert")
    public ResponseVo insert(@RequestBody Appointment appointment) {
        if (appointment.getStartTime().before(new Date())) {
            return new ResponseVo(Code.FAILED, "不能预约以前的时间！", null);
        }

        if(appointment.getStartTime().after(appointment.getEndTime())){
            return new ResponseVo(Code.FAILED, "预约开始时间不能在结束时间之后", null);
        }

        Staff staff = staffService.selectByNumber(appointment.getStaffNumber());
        if (staff.getStatus() == 0) {
            appointment.setStatus(0);
        } else {
            appointment.setStatus(1);
        }
        //判断房间是否还可以预约
        Room room = roomService.selectByNumber(appointment.getRoomNumber());
        if (room.getRestTimes() <= 0) {
            return new ResponseVo(Code.SUCCESS, "预约已达上限！", null);
        }

        Date startTime = appointment.getStartTime();
        Date endTime = appointment.getEndTime();
        //判断时间是否冲突
        boolean isOk = false;
        List<Appointment> apps = appointmentService.getListByRoomNumber(appointment.getRoomNumber());
        int size = apps.size();
        if (size == 0 || startTime.after(apps.get(0).getEndTime()) || endTime.before(apps.get(size - 1).getStartTime())) {
            isOk = true;
        } else {
            for (int i = 0; i < size - 1; i++) {
                if (endTime.before(apps.get(i).getStartTime()) && startTime.after(apps.get(i+1).getEndTime())) {
                    isOk = true;
                    break;
                }
            }
        }

        if (isOk) {
            //设置创建预约信息时房间信息的变化
            room.setRestTimes(room.getRestTimes() - 1);
            room.setHot(room.getHot() + 1);
            String number = appointment.getStaffNumber() + appointment.getRoomNumber() +  System.currentTimeMillis();
            appointment.setNumber(number);
            appointmentService.insert(appointment);
            roomService.update(room);
            return new ResponseVo(Code.SUCCESS, "预约成功！", null);
        } else {
            return new ResponseVo(Code.SUCCESS, "预约失败！和其他已预约时间冲突！", null);
        }
    }


    /**
     * 根据员工编号分页查询其所有的预约记录
     * @param staffNumber
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/getapplist")
    public ResponseVo getAppListByStaffNumber(@RequestParam("staffNumber") String staffNumber,
                                              @RequestParam("page") Integer page,
                                              @RequestParam("limit") Integer limit){
        List<Appointment> apps = appointmentService.getAppListByStaffNumberPQ(staffNumber, (page - 1) * limit, limit);
        HashMap<String, Object> map = new HashMap<>();
        map.put("appList", apps);
        map.put("count", appointmentService.getAllAppNumsByStaffNumber(staffNumber));
        if (apps.size() > 0) {
            return new ResponseVo(Code.SUCCESS, "查询预约信息列表成功！", map);
        } else {
            return new ResponseVo(Code.SUCCESS, "查询预约信息列表失败！", map);
        }
    }


    /**
     * 员工取消预约
     * @param appNumber
     * @return
     */
    @GetMapping("/cancelapp")
    public ResponseVo cancelAppointment(@RequestParam("appNumber") String appNumber){
        Appointment app = appointmentService.selectByNumber(appNumber);
        Room room = roomService.selectByNumber(app.getRoomNumber());
        room.setRestTimes(room.getRestTimes()+1);
        roomService.update(room);
        int res = appointmentService.deleteByNumber(appNumber);
        if (res!=0){
            return new ResponseVo(Code.SUCCESS, "预约取消成功！", null);
        }else {
            return new ResponseVo(Code.FAILED, "预约取消失败！", null);
        }

    }

}
