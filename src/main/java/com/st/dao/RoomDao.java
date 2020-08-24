package com.st.dao;

import com.st.entity.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomDao {

    Room selectByNumber(String number);

    int update(Room record);

    List<Room> getAll();

    List<Room> getHotList(Integer num);

}