package com.main.application.controllers.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class UpdatePercentDTO implements Serializable {
    
    private Long hospitalId;
    private BigDecimal percent;

    public Long getHospitalId() {
        return hospitalId;
    }
    public BigDecimal getPercent() {
        return percent;
    }
    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }
    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }
}
