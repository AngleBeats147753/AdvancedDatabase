package com.example.backend.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 黄磊
 * @since 2022/12/16
 **/
@Data
public class RecordDto {
    private Integer flightNum;
    private String airline;
    private LocalDateTime flightDate;
    private String originAirport;
    private String DestAirport;
    private Double DepTime;
    private Double arrTime;
    private String depCity;
    private String arrCity;
    private String depState;
    private String arrState;
    private Boolean canceled;
}
