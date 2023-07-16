package com.example.eventdemo.repository;

import com.example.eventdemo.domain.Attendance;
import com.example.eventdemo.domain.History;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AttendanceRepository {


    private final Map<Attendance.PrimaryKey, Attendance> attendanceMap = new HashMap<>();
    private final Map<History.PrimaryKey, Attendance.PrimaryKey> keyMap = new HashMap<>();

    public Attendance selectByKey(Attendance.PrimaryKey key) {
        return attendanceMap.get(key);
    }


    public void updateTime(Attendance attendance, long watchedTime) {
        attendance.setWatchedTime(watchedTime);
    }

    public void save(Attendance attendance) {
        attendanceMap.put(attendance.getKey(), attendance);
    }


    public Attendance.PrimaryKey getAttendanceKeyByHistoryKey(History.PrimaryKey key){
        return keyMap.get(key);
    }

}
