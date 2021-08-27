package com.main.application.repositories;

import java.util.List;

import com.main.application.models.History;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends CrudRepository<History, Long> {
    
    public List<History> findAll();
    
}
