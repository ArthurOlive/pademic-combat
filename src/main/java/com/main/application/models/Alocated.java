package com.main.application.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Alocated implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="alocated_generator")
	@SequenceGenerator(name="alocated_generator", sequenceName="alocated_seq", allocationSize=1)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Item itemAlocated;

    private Integer quantity;

    private LocalDateTime createdAt = LocalDateTime.now();

    public long getId() {
        return id;
    }
    public Item getItemAlocated() {
        return itemAlocated;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setItemAlocated(Item itemAlocated) {
        this.itemAlocated = itemAlocated;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
