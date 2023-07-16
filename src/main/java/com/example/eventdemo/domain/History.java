package com.example.eventdemo.domain;

import com.example.eventdemo.dto.WatchRequest;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class History {
    private PrimaryKey key;
    private long entryTime;
    private long watchedTime;


    public static History CreateHistory(WatchRequest request){
        History history = new History();
        PrimaryKey key = new PrimaryKey(request.getStudentId(), request.getLectureId(), request.getWeek(), request.getSequence());
        history.setKey(key);
        history.setWatchedTime(request.getWatchedTime());
        history.setEntryTime(request.getEntryTime());
        return history;
    }

    public record PrimaryKey(String studentId, String lectureId, int week, int sequence) {
    }

}
