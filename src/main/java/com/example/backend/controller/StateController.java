package com.example.backend.controller;

import com.example.backend.pojo.dto.ReturnResult;
import com.example.backend.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 州信息表 前端控制器
 * </p>
 *
 * @author zhoutianlan
 * @since 2022-12-12
 */
@RestController
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping("/states")
    public ReturnResult listState() {
        return stateService.listState();
    }
}
