package com.example.backend.manager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecordsManagerTest {

    @Autowired
    private RecordsManager recordsManager;
    @Test
    void listFlyNum() {
        recordsManager.listFlyNum(1L,3133);
    }

    @Test
    void getFlightPunctualityRate() {
       float result = recordsManager.getFlightPunctualityRate(1L,3133);
        System.out.println(result);
    }
}