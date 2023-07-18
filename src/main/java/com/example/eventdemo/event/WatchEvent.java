package com.example.eventdemo.event;

import com.example.eventdemo.domain.History;
import lombok.AllArgsConstructor;
import lombok.Getter;

public record WatchEvent (History.PrimaryKey historyKey) {
}
