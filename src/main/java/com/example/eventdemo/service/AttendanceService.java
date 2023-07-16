
package com.example.eventdemo.service;

import com.example.eventdemo.domain.Attendance;
import com.example.eventdemo.domain.History;
import com.example.eventdemo.event.WatchEvent;
import com.example.eventdemo.repository.AttendanceRepository;
import com.example.eventdemo.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final HistoryRepository historyRepository;

    @EventListener
    public void AttendanceLogic(WatchEvent event) {
        History.PrimaryKey historyKey = event.getHistoryKey();
        History history= historyRepository.getHistoryByHistoryKey(historyKey);
        log.info("이벤트수신 : " + history.toString());
        Attendance attendance= null;
        Attendance.PrimaryKey attendanceKey = attendanceRepository.getAttendanceKeyByHistoryKey(historyKey);
        if (attendanceKey == null) {
            attendanceKey = createAttendanceKey(historyKey);
            attendance= Attendance.CreateAttendance(attendanceKey, history);
            attendanceRepository.save(attendance);
        }

        attendance= attendanceRepository.selectByKey(attendanceKey);
        updateWatchedTime(attendance, history);

        if(isValid(attendanceKey)){
            attendance.setAttendance(true);
        }
    }

    private void updateWatchedTime(Attendance attendance, History history) {
        long entryTime = attendance.getEntryTime();
        long orgWatchedTime = attendance.getWatchedTime();
        long newWatchedTime = history.getWatchedTime();

        attendanceRepository.updateTime(attendance, Math.max(orgWatchedTime+newWatchedTime, entryTime));
    }

    private boolean isValid(Attendance.PrimaryKey key) {
        Attendance attendance = attendanceRepository.selectByKey(key);
        long entryTime = attendance.getEntryTime();
        long watchedTime = attendance.getWatchedTime();
        return watchedTime >= entryTime / 2 ? true : false;
    }
    private Attendance.PrimaryKey createAttendanceKey(History.PrimaryKey historyKey) {

        return new Attendance.PrimaryKey(historyKey.studentId(), historyKey.lectureId(), historyKey.week());
    }

}
