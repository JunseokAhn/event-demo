package com.example.eventdemo.event;

import com.example.eventdemo.domain.History;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WatchEvent {
    private History.PrimaryKey historyKey;
}
