package com.example.backend.pojo.dto;

import cn.hutool.core.util.ObjectUtil;
import com.example.backend.pojo.AirlineDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhoutianlan
 * @since 2022/12/12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirlineDto {

    private Long airlineId;

    private String airlineName;

    public AirlineDto(AirlineDO airlineDO) {
        if(ObjectUtil.isNotNull(airlineDO)) {
            this.airlineId = airlineDO.getId();
            this.airlineName = airlineDO.getAirline();
        }
    }
}
