package com.example.eventdemo.service;

import com.example.eventdemo.domain.History;
import com.example.eventdemo.dto.WatchRequest;
import com.example.eventdemo.event.WatchEvent;
import com.example.eventdemo.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final ApplicationEventPublisher eventPublisher;

    public void watched(WatchRequest request) {

        // 수강기록 집계
        History history = History.CreateHistory(request);
        History.PrimaryKey historyKey = historyRepository.save(history);

        // 출석이벤트 발행
        eventPublisher.publishEvent(new WatchEvent(historyKey));
    }

}
