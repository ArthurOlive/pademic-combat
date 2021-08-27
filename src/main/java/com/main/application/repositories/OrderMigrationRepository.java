package com.main.application.repositories;

import java.util.List;

import com.main.application.models.OrderMigration;
import com.main.application.models.StatusOrder;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMigrationRepository extends CrudRepository<OrderMigration, Long>{

    public List<OrderMigration> findAllByStatus(StatusOrder status);
    
}
