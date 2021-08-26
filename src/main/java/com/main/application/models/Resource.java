package com.main.application.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
public class Resource implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="resource_generator")
	@SequenceGenerator(name="resource_generator", sequenceName="resource_seq", allocationSize=1)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Alocated> alocateds;
    
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }
    public List<Alocated> getAlocateds() {
        return alocateds;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setAlocateds(List<Alocated> alocateds) {
        this.alocateds = alocateds;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
