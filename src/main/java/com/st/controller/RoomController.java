package com.st.controller;

import com.st.data.Code;
import com.st.data.ResponseVo;
import com.st.entity.Room;
import com.st.service.RoomService;
import com.st.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author : zhoufeng
 * @date : 2020/8/19
 */
@RestController
@RequestMapping("/room")
@Scope("session")
public class RoomController {
    @Autowired
    private RoomService roomService;


    /**
     * 获取所有房间信息
     * @return
     */
    @GetMapping("/getall")
    public ResponseVo getAll(){
        List<Room> rooms = roomService.getAll();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("roomList", rooms);
        map.put("count", rooms.size());
        if (rooms.size()>0){
            return new ResponseVo(Code.SUCCESS, "获取所有房间信息成功！", map);
        }else{
            return new ResponseVo(Code.SUCCESS, "获取所有房间信息失败！", map);
        }
    }

    /**
     * 获取前12个热门房间信息
     * @param num
     * @return
     */
    @GetMapping("/hotlist")
    public ResponseVo getHotRoomList(@RequestParam(value = "num", defaultValue = "12") Integer num){
        List<Room> hotList = roomService.getHotList(num);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("hotList", hotList);
        map.put("count", hotList.size());
        if (hotList.size()>0){
            return new ResponseVo(Code.SUCCESS, "获取热门房间信息成功！", map);
        }else{
            return new ResponseVo(Code.SUCCESS, "获取热门房间信息失败！", map);
        }
    }
}
