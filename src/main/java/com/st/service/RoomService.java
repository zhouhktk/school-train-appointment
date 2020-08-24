package com.st.service;

import com.st.dao.RoomDao;
import com.st.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : zhoufeng
 * @date : 2020/8/19
 */
@Transactional(readOnly = true)
@Service("roomService")
public class RoomService {
    @Autowired
    private RoomDao roomDao;


    public Room selectByNumber(String number) {
        return roomDao.selectByNumber(number);
    }

    @Transactional(readOnly = false)
    public int update(Room record) {
        return roomDao.update(record);
    }

    public List<Room> getAll() {
        return roomDao.getAll();
    }

    public List<Room> getHotList(Integer num){
        return roomDao.getHotList(num);
    }

}
