package com.example.backend.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.backend.manager.AirlineManager;
import com.example.backend.manager.StateManager;
import com.example.backend.pojo.AirlineDO;
import com.example.backend.pojo.StateDO;
import com.example.backend.pojo.dto.AirlineDto;
import com.example.backend.pojo.dto.ReturnResult;
import com.example.backend.pojo.dto.StateDto;
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
public class StateService {
    @Autowired
    private StateManager stateManager;

    public ReturnResult listState() {
        List<StateDO> stateDOList = stateManager.list();
        List<StateDto> resultList = new ArrayList<>();
        if (CollectionUtil.isNotEmpty(stateDOList)) {
            resultList = stateDOList.stream().map(StateDto::new).collect(Collectors.toList());
        }
        return ReturnResult.getSuccessReturn(resultList);
    }
}
