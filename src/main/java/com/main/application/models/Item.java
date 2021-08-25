package com.main.application.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Item implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="item_generator")
	@SequenceGenerator(name="item_generator", sequenceName="item_seq", allocationSize=1)
    private Long id;

    @Column(unique = true)
    private String name;

    private int points;

    private LocalDateTime createdAt = LocalDateTime.now();

    public void setId(long id) {
        this.id = id;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createAt) {
        this.createdAt = createAt;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getPoints() {
        return points;
    }

}
