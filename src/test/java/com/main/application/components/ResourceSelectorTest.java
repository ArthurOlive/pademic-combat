package com.main.application.components;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.main.application.models.Alocated;
import com.main.application.models.Item;

import org.junit.Test;

public class ResourceSelectorTest {

    @Test
    public void getAlocatedScore () {

        List<Alocated> alocateds = new ArrayList<>();
        
        for( int i = 0; i < 5;  i++ ) {
            
            Item item = new Item();
            item.setPoints(2);

            Alocated alocated = new Alocated();
            alocated.setItemAlocated(item);
            alocated.setQuantity(2);

            alocateds.add(alocated);
        }
        OrderProcessor selector = new OrderProcessor();

        assertEquals(20, selector.alocatedScore(alocateds));

    }

}
