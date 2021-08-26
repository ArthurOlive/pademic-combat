package com.main.application.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.main.application.controllers.dto.ApiResponse;
import com.main.application.models.Hospital;
import com.main.application.services.HospitalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController()
public class HospitalController {
    
    @Autowired
    private HospitalService hospitalService;


    @PostMapping("api/hospital")
    public ResponseEntity<ApiResponse<Hospital>> create( @Valid @RequestBody Hospital hospital) {

        System.out.println(hospital);
    
        List<Hospital> hospitals = new ArrayList<Hospital>();

        hospitals.add(hospitalService.save(hospital));
        ApiResponse<Hospital> response = new ApiResponse<Hospital>("Hospitais cadastrados", hospitals);

        return ResponseEntity.ok(response);
    }

    @GetMapping("api/hospital/{id}")
    public ResponseEntity<ApiResponse<?>> getById(@PathVariable("id") Long id) {
    
        List<Hospital> hospitals = new ArrayList<Hospital>();
        
        hospitals.add(hospitalService.getById(id));
        ApiResponse<Hospital> response = new ApiResponse<Hospital>("Hospitais cadastrados", hospitals);

        return ResponseEntity.ok(response);
    }

    @GetMapping("api/hospital")
    public ResponseEntity<ApiResponse<?>> getAll() {
    
        List<Hospital> hospitals = hospitalService.getAll();
        
        ApiResponse<Hospital> response = new ApiResponse<Hospital>("Hospitais cadastrados", hospitals);

        return ResponseEntity.ok(response);
    }

}
