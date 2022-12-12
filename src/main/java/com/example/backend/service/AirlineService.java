package com.example.backend.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.backend.manager.AirlineManager;
import com.example.backend.pojo.AirlineDO;
import com.example.backend.pojo.dto.AirlineDto;
import com.example.backend.pojo.dto.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhoutianlan
 * @since 2022/12/12
 */
@Service
public class AirlineService {

    @Autowired
    private AirlineManager airlineManager;

    public ReturnResult listAirline() {
        List<AirlineDO> airlineDOList = airlineManager.list();
        List<AirlineDto> resultList = new ArrayList<>();
        if (CollectionUtil.isNotEmpty(airlineDOList)) {
            resultList = airlineDOList.stream().map(AirlineDto::new).collect(Collectors.toList());
        }
        return ReturnResult.getSuccessReturn(resultList);
    }

}
