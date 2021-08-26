package com.main.application.services;

import java.util.List;

import com.main.application.models.Hospital;
import com.main.application.repositories.HospitalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HospitalService {
    
    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private ItemService itemService;

    public List<Hospital> getAll() {
        return hospitalRepository.findAll();
    }

    public Hospital getById(Long id) {
        return hospitalRepository.findById(id).orElseThrow();
    }
    
    @Transactional
    public Hospital save (Hospital hospital) {

        return hospitalRepository.save(hospital);
        
    }

}
