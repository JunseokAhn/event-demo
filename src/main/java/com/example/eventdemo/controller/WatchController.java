package com.example.eventdemo.controller;

import com.example.eventdemo.dto.WatchRequest;
import com.example.eventdemo.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("watch")
public class WatchController {
    private final HistoryService historyService;

    @GetMapping("/history/{lectureId}/{studentId}/{week}/{sequence}/{entryTime}/{watchedTime}")
    public String watchHistory (WatchRequest request){
        historyService.watched(request);
        return "redirect://index.html";
    }

}
