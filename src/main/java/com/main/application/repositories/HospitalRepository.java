package com.main.application.repositories;

import java.util.List;
import java.util.Optional;

import com.main.application.models.Hospital;

import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital, Long>{

    public List<Hospital> findAll();
    
    public Optional<Hospital> findById(Long id);
    
}
