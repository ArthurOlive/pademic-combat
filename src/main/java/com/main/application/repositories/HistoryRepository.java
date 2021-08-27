package com.main.application.repositories;

import com.main.application.models.History;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends CrudRepository<Long, History> {
    
}
