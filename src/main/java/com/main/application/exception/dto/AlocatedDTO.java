package com.main.application.exception.dto;

import java.io.Serializable;

import javax.validation.constraints.*;

public class AlocatedDTO implements Serializable {
    
    @NotBlank
    private Integer itemAlocated;

    @PositiveOrZero
    private Integer quantity;

    public Integer getItemAlocated() {
        return itemAlocated;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setItemAlocated(Integer itemAlocated) {
        this.itemAlocated = itemAlocated;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
