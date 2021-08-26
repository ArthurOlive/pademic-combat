package com.main.application.exception.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

public class ResourceDTO {

    private List<AlocatedDTO> alocateds;

    public List<AlocatedDTO> getAlocateds() {
        return alocateds;
    }
    public void setAlocateds(List<AlocatedDTO> alocateds) {
        this.alocateds = alocateds;
    }

}
