package com.main.application.controllers.dto;

import java.io.Serializable;
import java.util.List;
public class ResourceDTO implements Serializable {

    private List<AlocatedDTO> alocateds;

    public List<AlocatedDTO> getAlocateds() {
        return alocateds;
    }
    public void setAlocateds(List<AlocatedDTO> alocateds) {
        this.alocateds = alocateds;
    }

}
