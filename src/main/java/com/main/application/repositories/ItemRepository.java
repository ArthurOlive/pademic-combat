package com.main.application.repositories;

import java.util.List;
import java.util.Optional;

import com.main.application.models.Item;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long>{

    public List<Item> findAll();

    public Optional<Item> findById(Long id);
    
}
