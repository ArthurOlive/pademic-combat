package com.main.application.components;

import java.util.List;

import javax.naming.directory.InvalidAttributesException;
import javax.transaction.Transactional;

import com.main.application.models.Alocated;
import com.main.application.models.History;
import com.main.application.models.Hospital;
import com.main.application.models.Item;
import com.main.application.models.OrderMigration;
import com.main.application.models.Resource;
import com.main.application.services.HistoryService;
import com.main.application.services.HospitalService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessor {

    @Autowired
    private HistoryService historyService;

    @Autowired
    private HospitalService hospitalService;

    private Logger logger = LoggerFactory.getLogger(OrderProcessor.class);
 
    public Integer alocatedScore(List<Alocated> alocateds) {

        int score = 0;
        for (var alocated : alocateds) {
            score += alocated.getItemAlocated().getPoints() * alocated.getQuantity();
        }

        return score;

    }

    public boolean containsItem (Resource resource, Alocated alocate) {
        
        for (var alocated : resource.getAlocateds()) {

            if (alocated.getItemAlocated().getId() == alocate.getItemAlocated().getId() && 
                alocated.getQuantity() >= alocate.getQuantity()) {

                return true;
            }
        }

        return false;
    }

    public boolean validateResources(Hospital hospital, Resource resource) {

        boolean isValid = true; 

        for (var alocated : resource.getAlocateds()) {

            if (!containsItem(hospital.getResource(), alocated)) {
                isValid = false;
            }
            
        }
        
        return isValid;
    } 

    @Transactional
    public void process(OrderMigration order) throws InvalidAttributesException {

        logger.info("Iniciando processamento de intercambio: " + order.getId());

        logger.info("Validando recursos de hospital 1 id :" + order.getHospital1().getId());
        if (!validateResources(order.getHospital1(), order.getResource1())) {
            throw new InvalidAttributesException("A lista de recursos do hospital 1 não condiz com os recursos do hospital");
        }

        logger.info("Validando recursos de hospital 2 id :" + order.getHospital2().getId());
        if (!validateResources(order.getHospital2(), order.getResource2())) {
            throw new InvalidAttributesException("A lista de recursos do hospital 2 não condiz com os recursos do hospital");
        }

        Hospital hospital1 = order.getHospital1();
        Hospital hospital2 = order.getHospital1();

        logger.info("Desalocando recursos de hospital 1");
        for (var desalocate : order.getResource1().getAlocateds()) {
            for (var alocated : hospital1.getResource().getAlocateds()) {

                if (alocated.getItemAlocated().getId() == desalocate.getId()) {
                    alocated.setQuantity(alocated.getQuantity() - desalocate.getQuantity());
                }

            }
        }
        
        logger.info("Alocando recursos de hospital 1");
        for (var alocated : order.getResource2().getAlocateds()) {
            boolean processed = false;
            for (var alocate : hospital1.getResource().getAlocateds()) {

                if (alocate.getItemAlocated().getId() == alocated.getId()) {
                    alocate.setQuantity(alocated.getQuantity() + alocated.getQuantity());
                    processed = true;
                }

            }
            if(processed) {
                logger.info("Não contem item id: " + alocated.getId());
            }
        }

        logger.info("Desalocando recursos de hospital 2");
        for (var desalocate : order.getResource2().getAlocateds()) {
            for (var alocated : hospital2.getResource().getAlocateds()) {

                if (alocated.getItemAlocated().getId() == desalocate.getId()) {
                    alocated.setQuantity(alocated.getQuantity() - desalocate.getQuantity());
                }

            }
        }
        
        logger.info("Alocando recursos de hospital 2");
        for (var alocated : order.getResource1().getAlocateds()) {
            boolean processed = false;
            for (var alocate : hospital2.getResource().getAlocateds()) {

                if (alocate.getItemAlocated().getId() == alocated.getId()) {
                    alocate.setQuantity(alocated.getQuantity() + alocated.getQuantity());
                    processed = true;
                }

            }
            if(processed) {
                logger.info("Não contem item id: " + alocated.getId());
            }
        }

        logger.info("Salvando hospitais");
        hospitalService.save(hospital1);
        hospitalService.save(hospital2);

        History history1 = new History();
        history1.setHospitalTo(hospital1);
        history1.setHospitalTo(hospital2);
        history1.setResource(order.getResource1());
        
        History history2 = new History();
        history2.setHospitalTo(hospital2);
        history2.setHospitalTo(hospital1);
        history2.setResource(order.getResource2());

        logger.info("Salvando historico");
        historyService.save(history1);
        historyService.save(history2);
    }

}