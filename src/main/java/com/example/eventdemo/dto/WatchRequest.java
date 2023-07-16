package com.example.eventdemo.dto;

import lombok.Data;

@Data
public class WatchRequest {
    String lectureId;
    String studentId;
    int week;
    int sequence;
    long entryTime;
    long watchedTime;
}
