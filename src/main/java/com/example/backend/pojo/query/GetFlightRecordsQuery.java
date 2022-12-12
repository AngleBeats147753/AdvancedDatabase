package com.example.backend.pojo.query;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author 黄磊
 * @since 2022/12/12
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class GetFlightRecordsQuery extends PageQuery {
    private Integer airlineId;
    private Integer depStateId;
    private Integer depCityId;
    private Integer arrStateId;
    private Integer arrCityId;
//    @DateTimeFormat(pattern = "y-M-d H:m:s")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime flightDate;
}
