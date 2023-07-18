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
        PrimaryKey key = new PrimaryKey(request.studentId(), request.lectureId(), request.week(), request.sequence());
        history.setKey(key);
        history.setWatchedTime(request.watchedTime());
        history.setEntryTime(request.entryTime());
        return history;
    }

    public record PrimaryKey(String studentId, String lectureId, int week, int sequence) {
    }

}
