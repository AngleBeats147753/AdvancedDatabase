package com.example.backend.controller;

import com.example.backend.pojo.dto.ReturnResult;
import com.example.backend.pojo.query.GetFlightRecordsQuery;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 航班信息表 前端控制器
 * </p>
 *
 * @author zhoutianlan
 * @since 2022-12-12
 */
@RestController
@RequestMapping
public class RecordsController {
    @GetMapping("/flight/records")
    public ReturnResult getFlightRecords(@Validated GetFlightRecordsQuery query, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ReturnResult.getFailureReturn(bindingResult);
        }
        return null;
    }

}
