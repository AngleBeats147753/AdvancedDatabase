package com.example.backend.controller;

import com.example.backend.pojo.dto.ReturnResult;
import com.example.backend.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 城市信息表 前端控制器
 * </p>
 *
 * @author zhoutianlan
 * @since 2022-12-12
 */
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/city/{stateId}")
    public ReturnResult listByStateId(@PathVariable Long stateId) {
        return cityService.listCityByState(stateId);
    }
}
