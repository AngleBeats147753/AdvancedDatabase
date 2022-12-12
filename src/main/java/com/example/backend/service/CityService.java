package com.example.backend.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.backend.manager.CityManager;
import com.example.backend.manager.StateManager;
import com.example.backend.pojo.CityDO;
import com.example.backend.pojo.StateDO;
import com.example.backend.pojo.dto.CityDto;
import com.example.backend.pojo.dto.ReturnResult;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhoutianlan
 * @since 2022/12/12
 */
@Service
public class CityService {
    @Autowired
    private CityManager cityManager;
    @Autowired
    private StateManager stateManager;

    public ReturnResult listCityByState(Long stateId) {
        StateDO stateDO = stateManager.getById(stateId);
        if (ObjectUtil.isNull(stateDO))
            return ReturnResult.getFailureReturn("请选择州", "州不存在");
        List<CityDto> resultList = new ArrayList<>();
        List<CityDO> cityDOList = cityManager.listByStateId(stateId);
        if (CollectionUtil.isNotEmpty(cityDOList))
            resultList = cityDOList.stream().map(CityDto::new).collect(Collectors.toList());
        return ReturnResult.getSuccessReturn(resultList);
    }
}
