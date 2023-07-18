package com.example.eventdemo.dto;


public record WatchRequest(String lectureId, String studentId,
        int week, int sequence, long entryTime, long watchedTime) {
}
