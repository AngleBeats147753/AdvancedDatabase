package com.example.backend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.manager.AirportManager;
import com.example.backend.manager.CityManager;
import com.example.backend.manager.RecordsManager;
import com.example.backend.manager.StateManager;
import com.example.backend.pojo.*;
import com.example.backend.pojo.dto.ReturnResult;
import com.example.backend.pojo.query.GetFlightRecordsQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend.pojo.dto.PunctualityDto;


import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhoutianlan、黄磊
 * @since 2022/12/12
 **/
@Service
@Slf4j
public class RecordsService {
    @Autowired
    private StateManager stateManager;
    @Autowired
    private CityManager cityManager;
    @Autowired
    private AirportManager airportManager;
    @Autowired
    private RecordsManager recordsManager;

    public ReturnResult getFlightRecords(GetFlightRecordsQuery query) {
//        List<Long> cityDOList = null;
//        List<Long> depAirportList = null;
//        List<Long> arrAirportList = null;
//        if (query.getDepCityId() != null) {
//            arrAirportList = airportManager.list(new QueryWrapper<AirportDO>().eq(AirportDO.CITY_ID, query.getDepCityId())).stream().map(AirportDO::getId).collect(Collectors.toList());
//        }


//        new QueryWrapper<RecordsDO>()
//        recordsManager.list()
        List<RecordsDO> list = recordsManager.list(new QueryWrapper<RecordsDO>().
                eq(RecordsDO.AIRLINE_ID, 1));

        System.out.println(list.size());
        return null;
    }

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