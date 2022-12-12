package com.example.backend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.manager.AirportManager;
import com.example.backend.manager.CityManager;
import com.example.backend.manager.RecordsManager;
import com.example.backend.manager.StateManager;
import com.example.backend.pojo.AirportDO;
import com.example.backend.pojo.CityDO;
import com.example.backend.pojo.RecordsDO;
import com.example.backend.pojo.StateDO;
import com.example.backend.pojo.dto.ReturnResult;
import com.example.backend.pojo.query.GetFlightRecordsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 黄磊
 * @since 2022/12/12
 **/
@Service
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
}
