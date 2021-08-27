package com.main.application.controllers.dto;

import java.io.Serializable;

public class OrderMigrationDTO implements Serializable {
    
    private Long hospital1; 
    private Long hospital2;
    private ResourceDTO resources1;
    private ResourceDTO resources2;

    public Long getHospital1() {
        return hospital1;
    }
    public Long getHospital2() {
        return hospital2;
    }
    public ResourceDTO getResources1() {
        return resources1;
    }
    public ResourceDTO getResources2() {
        return resources2;
    }
    public void setHospital1(Long hospital1) {
        this.hospital1 = hospital1;
    }
    public void setHospital2(Long hospital2) {
        this.hospital2 = hospital2;
    }
    public void setResources1(ResourceDTO resources1) {
        this.resources1 = resources1;
    }
    public void setResources2(ResourceDTO resources2) {
        this.resources2 = resources2;
    }
}
