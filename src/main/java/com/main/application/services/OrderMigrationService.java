package com.main.application.services;

import java.util.List;

import com.main.application.models.OrderMigration;
import com.main.application.models.StatusOrder;
import com.main.application.repositories.OrderMigrationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMigrationService {
    
    @Autowired
    private OrderMigrationRepository orderMigrationRepository;

    public List<OrderMigration> getAllByStatus(StatusOrder status) {
        return orderMigrationRepository.findAllByStatus(status);
    }
}
