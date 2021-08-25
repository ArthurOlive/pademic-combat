package com.main.application.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Hospital implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="hospital_generator")
	@SequenceGenerator(name="hospital_generator", sequenceName="hospital_seq", allocationSize=1)
    private Long id;

    private String name;

    @Column(unique = true)
    private String cnpj;

    private String address;

    private BigDecimal lat;

    private BigDecimal log;

    private BigDecimal percent;

    @OneToOne(fetch=FetchType.LAZY)
    private Resource resource;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public Resource getResource() {
        return resource;
    }
    public BigDecimal getLog() {
        return log;
    }
    public BigDecimal getLat() {
        return lat;
    }
    public String getAddress() {
        return address;
    }
    public String getCnpj() {
        return cnpj;
    }
    public String getName() {
        return name;
    }
    public BigDecimal getPercent() {
        return percent;
    }
    public void setResource (Resource resource) {
        this.resource = resource;
    }
    public void setCreateAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public void setLog(BigDecimal log) {
        this.log = log;
    }
    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }
}
