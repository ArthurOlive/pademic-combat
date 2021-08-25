package com.main.application.repositories;

import java.util.List;

import com.main.application.models.Item;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long>{

    public List<Item> findAll();
    
}
