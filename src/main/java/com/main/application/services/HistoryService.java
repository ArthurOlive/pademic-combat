package com.main.application.services;

import java.util.List;

import com.main.application.models.History;
import com.main.application.repositories.HistoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {   

    @Autowired
    private HistoryRepository historyRepository;
 
    public void save(History history) {
        historyRepository.save(history);
    }

    public List<History> getAll() {
        return historyRepository.findAll();
    }

}
