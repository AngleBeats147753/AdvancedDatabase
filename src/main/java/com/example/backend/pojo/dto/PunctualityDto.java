package com.example.backend.pojo.dto;

import lombok.Data;

import java.util.List;

/**
 * @author zhoutianlan
 * @since 2022/12/12
 */
@Data
public class PunctualityDto {
    /**
     * 总的准点率
     */
    private double punctualityRate;

    /**
     * 每月飞行次数
     */
    private List<FlyNumDto> flyNumList;
}
