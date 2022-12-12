package com.example.backend.manager.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.pojo.FlyNumDO;
import com.example.backend.pojo.RecordsDO;
import com.example.backend.dao.RecordsDao;
import com.example.backend.manager.RecordsManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.pojo.dto.FlyNumDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 航班信息表 服务实现类
 * </p>
 *
 * @author zhoutianlan
 * @since 2022-12-12
 */
@Service
public class RecordsManagerImp extends ServiceImpl<RecordsDao, RecordsDO> implements RecordsManager {

    @Override
    public float getFlightPunctualityRate(Long airlineId, Integer flightNum){
        QueryWrapper<RecordsDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(RecordsDO.AIRLINE_ID,airlineId)
                .eq(RecordsDO.FLIGHT_NUMBER_OPERATING_AIRLINE,flightNum);
        long totalNum = count(queryWrapper);

        queryWrapper.eq(RecordsDO.DEPDELAY,0);
        long punctualityNum = count(queryWrapper);
        if(totalNum == 0)
            return 0;

        return (float)punctualityNum/totalNum;
    }

    @Override
    public List<FlyNumDO> listFlyNum(Long airlineId, Integer flightNum){
        QueryWrapper<RecordsDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(RecordsDO.AIRLINE_ID,airlineId)
                .eq(RecordsDO.FLIGHT_NUMBER_OPERATING_AIRLINE,flightNum)
                .select("DATE_FORMAT(flight_date,'%Y-%m') as month,count(1) totalNum")
                .groupBy("month").orderByAsc("month");
        //List<FlyNumDO> totalList = mapToList(listMaps(queryWrapper));

        return null;
    }

}
