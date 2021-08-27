package com.main.application.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class OrderMigration implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="order_generator")
	@SequenceGenerator(name="order_generator", sequenceName="order_seq", allocationSize=1)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Hospital hospital1;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Hospital hospital2;

    @OneToOne(cascade = CascadeType.ALL)
    private Resource resource1;

    @OneToOne(cascade = CascadeType.ALL)
    private Resource resource2;

    private String message;

    private StatusOrder status;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }
    public Hospital getHospital1() {
        return hospital1;
    }
    public Resource getResource1() {
        return resource1;
    }
    public Resource getResource2() {
        return resource2;
    }
    public Hospital getHospital2() {
        return hospital2;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public StatusOrder getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }
    public void setHospital1(Hospital hospital1) {
        this.hospital1 = hospital1;
    }
    public void setHospital2(Hospital hospital2) {
        this.hospital2 = hospital2;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setResource1(Resource resource1) {
        this.resource1 = resource1;
    }
    public void setResource2(Resource resource2) {
        this.resource2 = resource2;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public void setStatus(StatusOrder status) {
        this.status = status;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
