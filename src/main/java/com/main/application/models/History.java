package com.main.application.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class History implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="alocated_generator")
	@SequenceGenerator(name="alocated_generator", sequenceName="alocated_seq", allocationSize=1)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Hospital hospitalFrom;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Hospital hospitalTo;

    @OneToOne(cascade = CascadeType.ALL)
    private Resource resource;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }
    public Hospital getHospitalFrom() {
        return hospitalFrom;
    }
    public Resource getResource() {
        return resource;
    }
    public Hospital getHospitalTo() {
        return hospitalTo;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setHospitalFrom(Hospital hospitalFrom) {
        this.hospitalFrom = hospitalFrom;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setResource(Resource resource) {
        this.resource = resource;
    }
    public void setHospitalTo(Hospital hospitalTo) {
        this.hospitalTo = hospitalTo;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
