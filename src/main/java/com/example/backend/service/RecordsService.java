package com.example.backend.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.backend.manager.AirlineManager;
import com.example.backend.manager.RecordsManager;
import com.example.backend.pojo.AirlineDO;
import com.example.backend.pojo.dto.PunctualityDto;
import com.example.backend.pojo.dto.ReturnResult;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhoutianlan
 * @since 2022/12/12
 */
@Service
@Slf4j
public class RecordsService {
    @Autowired
    private AirlineManager airlineManager;

    @Autowired
    private RecordsManager recordsManager;

    public ReturnResult getPunctuality(String flightNum) {
        PunctualityDto result = new PunctualityDto();
        try {
            String airlineCode = flightNum.substring(0, 2);
            Integer flightNumber = Integer.valueOf(flightNum.substring(2));

            //查找航空公司ID
            AirlineDO airlineDO = airlineManager.getByAirlineCode(airlineCode);
            if (ObjectUtil.isNull(airlineDO)) return ReturnResult.getFailureReturn("输入的航班号有误");
            Long airlineId = airlineDO.getId();
            //查询总的准点率
            float punctualityRate = recordsManager.getFlightPunctualityRate(airlineId, flightNumber);
            //查询每个月的飞行总次数/准点次数


        } catch (NumberFormatException e) {
            log.error("[getPunctuality()] exception = ", e);
            return ReturnResult.getFailureReturn("输入的航班号有误");
        }
        return ReturnResult.getSuccessReturn(result);
    }
}
