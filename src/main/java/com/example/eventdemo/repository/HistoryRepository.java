package com.example.eventdemo.repository;

import com.example.eventdemo.domain.History;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class HistoryRepository {

    private final Map<History.PrimaryKey, History> historyMap = new HashMap<>();

    public History.PrimaryKey save(History history) {
        History.PrimaryKey historyKey = history.getKey();
        historyMap.put(historyKey, history);
        return historyKey;
    }

    public History getHistoryByHistoryKey(History.PrimaryKey historyKey) {
        return historyMap.get(historyKey);
    }
}
