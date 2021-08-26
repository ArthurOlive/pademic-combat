package com.main.application.controllers;

import java.util.List;

import com.main.application.controllers.dto.ApiResponse;
import com.main.application.models.Item;
import com.main.application.services.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;
    
    @GetMapping("api/item")
    public ResponseEntity<ApiResponse<Item>> get(){
        List<Item> items = itemService.getAll();

        ApiResponse<Item> api = new ApiResponse<Item>("Items registrados", items);

        return ResponseEntity.ok(api);
    }
}
