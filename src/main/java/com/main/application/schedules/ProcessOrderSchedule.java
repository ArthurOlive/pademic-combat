package com.main.application.schedules;

import java.util.List;

import com.main.application.components.OrderProcessor;
import com.main.application.models.OrderMigration;
import com.main.application.models.StatusOrder;
import com.main.application.services.OrderMigrationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.javacrumbs.shedlock.core.SchedulerLock;

@Component
public class ProcessOrderSchedule {

    @Autowired
    private OrderMigrationService orderMigrationService;

    @Autowired
    private OrderProcessor orderProcessor;

    private Logger logger = LoggerFactory.getLogger(ProcessOrderSchedule.class);
    
    @Scheduled(cron = "0 0/1 * * * *")
    @SchedulerLock(name = "ProcessOrderSchedule", lockAtMostFor = 45)
    public void processOrder() {

        logger.info("Processando intercabio de recursos abertos");
        List<OrderMigration> orders = orderMigrationService.getAllByStatus(StatusOrder.NEW);

        for (var order : orders) {
            
            try {

                orderProcessor.process(order.getId());

            } catch (Exception e) {

                e.printStackTrace();
                
            }
        }

    }
}
