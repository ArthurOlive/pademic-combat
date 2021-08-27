package com.main.application.services;

import java.util.List;

import com.main.application.controllers.dto.HospitalDTO;
import com.main.application.models.Alocated;
import com.main.application.models.Hospital;
import com.main.application.models.Resource;
import com.main.application.repositories.HospitalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    
    public Hospital save (Hospital hospital) {

        return hospitalRepository.save(hospital);
        
    }

    public Hospital saveDto(HospitalDTO hospitalDto) {

        Hospital hospital = new Hospital();

        hospital.setName(hospitalDto.getName());
        hospital.setCnpj(hospitalDto.getCnpj());
        hospital.setLat(hospitalDto.getLat());
        hospital.setLog(hospitalDto.getLog());
        hospital.setPercent(hospitalDto.getPercent());

        Resource resource = new Resource();

        for( var alocatedDto : hospitalDto.getResource().getAlocateds() ) {
            
            Alocated alocated = new Alocated();
            alocated.setItemAlocated(itemService.getById(alocatedDto.getItemAlocated()));
            alocated.setQuantity(alocatedDto.getQuantity());
            
            resource.getAlocateds().add(alocated);
        }
        
        hospital.setResource(resource);

        return hospitalRepository.save(hospital);
        
    }

}
