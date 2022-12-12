package com.example.backend.pojo.dto;

import cn.hutool.core.util.ObjectUtil;
import com.example.backend.pojo.AirlineDO;
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
public class StateDto {


    private Long stateId;

    private String stateName;

    public StateDto(StateDO stateDO) {
        if(ObjectUtil.isNotNull(stateDO)) {
            this.stateId = stateDO.getId();
            this.stateName = stateDO.getStateName();
        }
    }
}
