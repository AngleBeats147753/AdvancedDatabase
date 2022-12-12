package com.example.backend.manager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecordsManagerTest {

    @Autowired
    private RecordsManager recordsManager;
    @Test
    void listFlyNum() {
        recordsManager.listFlyNum(1L,3133);
    }
}