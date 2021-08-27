package com.main.application.services;

import java.util.List;

import com.main.application.controllers.dto.OrderMigrationDTO;
import com.main.application.models.Alocated;
import com.main.application.models.OrderMigration;
import com.main.application.models.Resource;
import com.main.application.models.StatusOrder;
import com.main.application.repositories.OrderMigrationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMigrationService {
    
    @Autowired
    private OrderMigrationRepository orderMigrationRepository;

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private ItemService itemService;

    public List<OrderMigration> getAllByStatus(StatusOrder status) {
        return orderMigrationRepository.findAllByStatus(status);
    }

    public OrderMigration getById(Long id) {
        return orderMigrationRepository.findById(id).orElseThrow();
    }

    public void save(OrderMigration order) {
        orderMigrationRepository.save(order);
    }

    public void saveDto(OrderMigrationDTO orderMigrationDTO) {

        OrderMigration orderMigration = new OrderMigration();

        orderMigration.setHospital1(hospitalService.getById(orderMigrationDTO.getHospital1()));
        orderMigration.setHospital2(hospitalService.getById(orderMigrationDTO.getHospital2()));
        
        Resource resource1 = new Resource();

        for( var alocatedDto : orderMigrationDTO.getResources1().getAlocateds() ) {
            
            Alocated alocated = new Alocated();
            alocated.setItemAlocated(itemService.getById(alocatedDto.getItemAlocated()));
            alocated.setQuantity(alocatedDto.getQuantity());
            
            resource1.getAlocateds().add(alocated);
        }

        Resource resource2 = new Resource();

        for( var alocatedDto : orderMigrationDTO.getResources2().getAlocateds() ) {
            
            Alocated alocated = new Alocated();
            alocated.setItemAlocated(itemService.getById(alocatedDto.getItemAlocated()));
            alocated.setQuantity(alocatedDto.getQuantity());
            
            resource2.getAlocateds().add(alocated);
        }

        orderMigration.setResource1(resource1);
        orderMigration.setResource2(resource2);

        orderMigration.setStatus(StatusOrder.NEW);

        orderMigrationRepository.save(orderMigration);
    }
}
