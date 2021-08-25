package com.main.application.repositories;

import com.main.application.models.Resource;

import org.springframework.data.repository.CrudRepository;

public interface ResourceRepository extends CrudRepository<Resource, Long>{
    
}
