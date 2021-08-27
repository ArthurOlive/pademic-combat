package com.main.application.services;

import com.main.application.models.History;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {   

    @Autowired
    private HistoryService historyService;
 
    public void save(History history) {
        historyService.save(history);
    }

}
