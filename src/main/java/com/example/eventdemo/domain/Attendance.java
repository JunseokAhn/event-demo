package com.example.eventdemo.domain;

import lombok.Data;

@Data
public class Attendance {
    private PrimaryKey key;
    private long entryTime;
    private long watchedTime;
    private boolean attendance;

    private Attendance (PrimaryKey key, long entryTime, long watchedTime){
        this.key= key;
        this.entryTime= entryTime;
        this.watchedTime= watchedTime;
    }

    public static Attendance CreateAttendance(PrimaryKey attendanceKey, History history) {

        return new Attendance(attendanceKey, history.getEntryTime(), history.getWatchedTime());
    }

    public record PrimaryKey(String studentId, String lectureId, int week) {
    }

}
