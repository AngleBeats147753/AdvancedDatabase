package com.example.backend.pojo.dto;

import lombok.Data;

/**
 * 每月飞行次数
 *
 * @author zhoutianlan
 * @since 2022/12/12
 */
@Data
public class FlyNumDto {
    /**
     * 月份
     */
    private Integer month;
    /**
     * 总飞行次数
     */
    private Integer totalNum;

    /**
     * 准点的飞行次数
     */
    private Integer punctualityNum;
}
