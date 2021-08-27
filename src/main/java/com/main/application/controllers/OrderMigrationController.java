package com.main.application.controllers;

import javax.validation.Valid;

import com.main.application.controllers.dto.ApiResponse;
import com.main.application.controllers.dto.OrderMigrationDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin
@RestController
public class OrderMigrationController {
        
    @PostMapping("api/orderMigration") 
    public ResponseEntity<ApiResponse<?>> create(@RequestBody @Valid OrderMigrationDTO orderMigrationDTO) {



        
        ApiResponse<?> response = new ApiResponse<>("Ordem criada com sucesso", null);

        return ResponseEntity.ok(response);
    }
}
