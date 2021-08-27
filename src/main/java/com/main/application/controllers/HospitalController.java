package com.main.application.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.main.application.controllers.dto.ApiResponse;
import com.main.application.controllers.dto.HospitalDTO;
import com.main.application.controllers.dto.OrderMigrationDTO;
import com.main.application.controllers.dto.UpdatePercentDTO;
import com.main.application.models.Hospital;
import com.main.application.models.Item;
import com.main.application.services.HospitalService;
import com.main.application.services.ItemService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController()
public class HospitalController {
    
    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private ItemService itemService;

    private Logger logger = LoggerFactory.getLogger(HospitalController.class);

    @PostMapping("api/hospital")
    public ResponseEntity<ApiResponse<Hospital>> create(@RequestBody @Valid HospitalDTO hospital) {

        logger.info("Criando hospital");

        System.out.println(hospital);
    
        List<Hospital> hospitals = new ArrayList<Hospital>();

        hospitals.add(hospitalService.saveDto(hospital));
        ApiResponse<Hospital> response = new ApiResponse<Hospital>("Hospital criado com sucesso", hospitals);

        return ResponseEntity.ok(response);
    }

    @PutMapping("api/hospital/migrate")
    public ResponseEntity<ApiResponse<?>> migrate (@RequestBody @Valid OrderMigrationDTO migrateDto) {

        logger.info("Migrando recursos entre os hospitais ");
    
        ApiResponse<Hospital> response = new ApiResponse<Hospital>("Hospital criado com sucesso", null);

        return ResponseEntity.ok(response);
    }

    @GetMapping("api/hospital/{id}")
    public ResponseEntity<ApiResponse<?>> getById(@PathVariable("id") Long id) {
    
        List<Hospital> hospitals = new ArrayList<Hospital>();
        
        hospitals.add(hospitalService.getById(id));
        ApiResponse<Hospital> response = new ApiResponse<Hospital>("", hospitals);

        return ResponseEntity.ok(response);
    }

    @GetMapping("api/hospital")
    public ResponseEntity<ApiResponse<?>> getAll(@RequestParam(value = "minPercent", required = false ) BigDecimal minPercent, 
                                                 @RequestParam(value = "maxPercent", required = false ) BigDecimal maxPercent) {
    
        List<Hospital> hospitals = hospitalService.getAll();

        if (minPercent != null) {
            hospitals = hospitals.stream().filter(hospital -> hospital.getPercent().compareTo(minPercent) >= 0).collect(Collectors.toList());
        }

        if (maxPercent != null) {
            hospitals = hospitals.stream().filter(hospital -> hospital.getPercent().compareTo(maxPercent) <= 0).collect(Collectors.toList());
        }
        
        ApiResponse<Hospital> response = new ApiResponse<Hospital>("Sucesso", hospitals);

        return ResponseEntity.ok(response);
    }

    @PutMapping("api//updatePercent")
    public ResponseEntity<ApiResponse<?>> updatePercent(@RequestBody @Valid UpdatePercentDTO updatePercentDTO) {
    
        Hospital hospital = hospitalService.getById(updatePercentDTO.getHospitalId());
        hospital.setPercent(updatePercentDTO.getPercent());
        
        List<Hospital> hospitals = hospitalService.getAll();
        
        hospitals.add(hospitalService.save(hospital));
        ApiResponse<Hospital> response = new ApiResponse<Hospital>("Percentual atualizado", hospitals);

        return ResponseEntity.ok(response);
    }

    @GetMapping("api/hospital/items")
    public ResponseEntity<ApiResponse<?>> getByHospitals(){

        List<Item> items = itemService.getAll();
        List<Hospital> hospitals = hospitalService.getAll();

        Map<Long, BigDecimal> quantiyItemsPerHospitals = new HashMap<>();

        for (var item : items) {
            quantiyItemsPerHospitals.put(item.getId(), BigDecimal.ZERO);
        }
        
        for (var hospital : hospitals) {
            for(var alocated : hospital.getResource().getAlocateds()) {
                
                BigDecimal newValue = quantiyItemsPerHospitals.get(alocated.getItemAlocated().getId()).add(new BigDecimal(alocated.getQuantity()));
                quantiyItemsPerHospitals.put(alocated.getItemAlocated().getId(), newValue);

            }
        }

        for (var item : items) {
            quantiyItemsPerHospitals.put(item.getId(), quantiyItemsPerHospitals.get(item.getId()).divide(new BigDecimal(hospitals.size()), 2, RoundingMode.CEILING));
        }

        List<Map<Long, BigDecimal>> response = new ArrayList<>();
        response.add(quantiyItemsPerHospitals);
        ApiResponse<Map<Long, BigDecimal>> api = new ApiResponse<>("Items por usina", response);

        return ResponseEntity.ok(api);
    }

}
