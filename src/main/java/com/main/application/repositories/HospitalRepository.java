package com.main.application.repositories;

import com.main.application.models.Hospital;

import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital, Long>{
    
}
