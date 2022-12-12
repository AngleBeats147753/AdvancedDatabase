package com.example.backend.manager;

import com.example.backend.pojo.FlyNumDO;
import com.example.backend.pojo.RecordsDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend.pojo.dto.FlyNumDto;

import java.util.List;

/**
 * <p>
 * 航班信息表 服务类
 * </p>
 *
 * @author zhoutianlan
 * @since 2022-12-12
 */
public interface RecordsManager extends IService<RecordsDO> {

    float getFlightPunctualityRate(Long airlineId, Integer flightNum);

    List<FlyNumDO> listFlyNum(Long airlineId, Integer flightNum);
}
