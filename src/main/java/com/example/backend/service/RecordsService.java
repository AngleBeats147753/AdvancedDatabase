package com.example.backend.service;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.manager.*;
import com.example.backend.pojo.*;
import com.example.backend.pojo.dto.PageDTO;
import com.example.backend.pojo.dto.RecordDto;
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
    private AirlineManager airlineManager;
    @Autowired
    private RecordsManager recordsManager;

    public ReturnResult getFlightRecords(GetFlightRecordsQuery query) {
        List<Long> depAirportList = null;
        List<Long> arrAirportList = null;
        if (query.getDepCityId() != null) {
            depAirportList = airportManager.list(new QueryWrapper<AirportDO>().eq(AirportDO.CITY_ID, query.getDepCityId())).stream().map(AirportDO::getId).collect(Collectors.toList());
        } else if (query.getDepStateId() != null) {
            List<Long> cityList = cityManager.list(new QueryWrapper<CityDO>().eq(CityDO.STATE_ID, query.getDepStateId())).stream().map(CityDO::getId).collect(Collectors.toList());
            depAirportList = airportManager.list(new QueryWrapper<AirportDO>().in(AirportDO.CITY_ID, cityList)).stream().map(AirportDO::getId).collect(Collectors.toList());
        }

        if (query.getArrCityId() != null) {
            arrAirportList = airportManager.list(new QueryWrapper<AirportDO>().eq(AirportDO.CITY_ID, query.getArrCityId())).stream().map(AirportDO::getId).collect(Collectors.toList());
        } else if (query.getArrStateId() != null) {
            List<Long> cityList = cityManager.list(new QueryWrapper<CityDO>().eq(CityDO.STATE_ID, query.getArrStateId())).stream().map(CityDO::getId).collect(Collectors.toList());
            arrAirportList = airportManager.list(new QueryWrapper<AirportDO>().in(AirportDO.CITY_ID, cityList)).stream().map(AirportDO::getId).collect(Collectors.toList());
        }

        PageDTO<RecordsDO> page = recordsManager.page(new PageDTO<>(query.getCurrentPage(), query.getPageSize()), new QueryWrapper<RecordsDO>()
                .eq(query.getAirlineId() != null, RecordsDO.AIRLINE_ID, query.getAirlineId())
                .eq(query.getFlightDate() != null, RecordsDO.FLIGHT_DATE, query.getFlightDate())
                .in(depAirportList != null, RecordsDO.ORIGIN_AIRPORT_ID, depAirportList)
                .in(arrAirportList != null, RecordsDO.DEST_AIRPORT_ID, arrAirportList)
        );
        List<RecordDto> recordDtoList = page.getRecords().stream().map((e) -> {
            RecordDto dto = new RecordDto();
            dto.setFlightNum(e.getFlightNumberOperatingAirline());
            AirlineDO airlineDO = airlineManager.getById(e.getAirlineId());
            dto.setAirline(airlineDO.getAirline());
            dto.setFlightDate(e.getFlightDate());
            dto.setDepTime(e.getDepTime());
            dto.setArrTime(e.getArrTime());
            dto.setCanceled(e.getCancelled() > 0);

            List<AirportDO> airportDOList = airportManager.listByIds(List.of(e.getOriginAirportId(), e.getDestAirportId()));
            AirportDO originAirport = airportDOList.get(0);
            dto.setOriginAirport(originAirport.getAirportCode());
            AirportDO destAirport = airportDOList.get(1);
            dto.setDestAirport(destAirport.getAirportCode());

            List<CityDO> cityDOList = cityManager.listByIds(airportDOList.stream().map(AirportDO::getCityId).collect(Collectors.toList()));
            CityDO originCity = cityDOList.get(0);
            dto.setDepCity(originCity.getCityName());
            CityDO destCity = cityDOList.get(1);
            dto.setArrCity(destCity.getCityName());

            List<StateDO> stateDOList = stateManager.listByIds(cityDOList.stream().map(CityDO::getId).collect(Collectors.toList()));
            StateDO originState = stateDOList.get(0);
            dto.setDepState(originState.getStateName());
            StateDO destState = stateDOList.get(1);
            dto.setArrState(destState.getStateName());
            return dto;
        }).collect(Collectors.toList());

        return ReturnResult.getSuccessReturn(new PageDTO<>(page.getSize(), page.getTotal(), recordDtoList));
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
            result.setPunctualityRate(punctualityRate);
            result.setFlyNumList(recordsManager.listFlyNum(airlineId, flightNumber));
        } catch (NumberFormatException e) {
            log.error("[getPunctuality()] exception = ", e);
            return ReturnResult.getFailureReturn("输入的航班号有误");
        }
        return ReturnResult.getSuccessReturn(result);
    }
}