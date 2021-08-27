package com.main.application.controllers;

import javax.validation.Valid;

import com.main.application.controllers.dto.ApiResponse;
import com.main.application.controllers.dto.OrderMigrationDTO;
import com.main.application.services.OrderMigrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class OrderMigrationController {

    @Autowired
    private OrderMigrationService orderMigrationService;
        
    @PostMapping("api/orderMigration") 
    public ResponseEntity<ApiResponse<?>> create(@RequestBody @Valid OrderMigrationDTO orderMigrationDTO) {

        orderMigrationService.saveDto(orderMigrationDTO);
        
        ApiResponse<?> response = new ApiResponse<>("Ordem criada com sucesso", null);

        return ResponseEntity.ok(response);
    }
}
