package com.main.application.services;

import java.util.List;
import java.util.Map;

import com.main.application.models.Item;
import com.main.application.repositories.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    public Item getById(Long id) {
        return itemRepository.findById(id).orElseThrow();
    }

}
