package com.main.application.exception.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.*;

public class HospitalDTO implements Serializable {
    
    private String name;

    @NotBlank
    @Size(min = 14, max = 14, message = "O cnpj deve ter 14 caracteres")
    private String cnpj;

    private String address;

    @Max(value = 90, message = "Latitude acima de 90°")
    @Min(value = 0,  message = "Latitude abaixo de 0")
    private BigDecimal lat;

    @Max(value = 180,message = "Latitude acima de 180")
    @Min(value = 0,  message = "Latitude abaixo de 0")
    private BigDecimal log;

    @Max(value = 100,message = "Porcentagem acima de 100%")
    @Min(value = 0,  message = "Porcentagem acima de 0%")
    private BigDecimal percent;

    private ResourceDTO resource;

    public String getAddress() {
        return address;
    }
    public String getCnpj() {
        return cnpj;
    }
    public BigDecimal getLat() {
        return lat;
    }
    public BigDecimal getLog() {
        return log;
    }
    public String getName() {
        return name;
    }
    public BigDecimal getPercent() {
        return percent;
    }
    public ResourceDTO getResource() {
        return resource;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }
    public void setLog(BigDecimal log) {
        this.log = log;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }
    public void setResource(ResourceDTO resource) {
        this.resource = resource;
    }

}
