package com.main.application.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController()
public class HospitalController {
    
    @PostMapping("api/hospital/create")
    public void create() {

    }
}
