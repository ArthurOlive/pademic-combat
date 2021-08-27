package com.main.application.controllers.dto;

import java.io.Serializable;

import javax.validation.constraints.*;

public class AlocatedDTO implements Serializable {
    
    @NotBlank
    private Long itemAlocated;

    @PositiveOrZero
    private Integer quantity;

    public Long getItemAlocated() {
        return itemAlocated;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setItemAlocated(Long itemAlocated) {
        this.itemAlocated = itemAlocated;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
