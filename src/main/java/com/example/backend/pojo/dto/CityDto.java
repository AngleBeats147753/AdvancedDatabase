package com.example.backend.pojo.dto;

import cn.hutool.core.util.ObjectUtil;
import com.example.backend.pojo.CityDO;
import com.example.backend.pojo.StateDO;
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
public class CityDto {


    private Long cityId;

    private String cityName;

    public CityDto(CityDO cityDO) {
        if(ObjectUtil.isNotNull(cityDO)) {
            this.cityId = cityDO.getId();
            this.cityName = cityDO.getCityName();
        }
    }
}
