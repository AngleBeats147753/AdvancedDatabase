package com.example.backend.manager.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    public float getFlightPunctualityRate(Long airlineId, Integer flightNum) {
        QueryWrapper<RecordsDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(RecordsDO.AIRLINE_ID, airlineId)
                .eq(RecordsDO.FLIGHT_NUMBER_OPERATING_AIRLINE, flightNum);
        long totalNum = count(queryWrapper);

        queryWrapper.le(RecordsDO.DEPDELAY, 0);
        long punctualityNum = count(queryWrapper);
        if (totalNum == 0)
            return 0;

        return (float) punctualityNum / totalNum;
    }

    @Override
    public List<FlyNumDto> listFlyNum(Long airlineId, Integer flightNum) {
        QueryWrapper<RecordsDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(RecordsDO.AIRLINE_ID, airlineId)
                .eq(RecordsDO.FLIGHT_NUMBER_OPERATING_AIRLINE, flightNum)
                .select("DATE_FORMAT(flight_date,'%Y-%m') as month,count(1) totalNum")
                .groupBy("month").orderByAsc("month");
        List<Map<String, Object>> totalListMap = listMaps(queryWrapper);

        QueryWrapper<RecordsDO> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq(RecordsDO.AIRLINE_ID, airlineId)
                .eq(RecordsDO.FLIGHT_NUMBER_OPERATING_AIRLINE, flightNum)
                .select("DATE_FORMAT(flight_date,'%Y-%m') as month,count(1) punctualityNum")
                .le(RecordsDO.DEPDELAY, 0)
                .groupBy("month").orderByAsc("month");

        List<Map<String, Object>> punctualityListMap = listMaps(queryWrapper2);

        return listToFlyNumDto(totalListMap, punctualityListMap);


    }

    private List<FlyNumDto> listToFlyNumDto(List<Map<String, Object>> totalListMap, List<Map<String, Object>> punctualityListMap) {
        Map<Integer, Integer> mapTotal = listToMap(totalListMap);
        Map<Integer, Integer> mapPunctuality = listToMap(punctualityListMap);
        List<FlyNumDto> list = new ArrayList<>();
        if (CollectionUtil.isNotEmpty(mapTotal)) {
            for (Map.Entry<Integer, Integer> entry : mapTotal.entrySet()) {
                Integer key = entry.getKey();
                FlyNumDto flyNumDto = new FlyNumDto();
                flyNumDto.setMonth(key);
                flyNumDto.setTotalNum(entry.getValue());
                flyNumDto.setPunctualityNum(mapPunctuality.get(key));
                list.add(flyNumDto);
            }
        }
        return list;
    }

    private Map<Integer, Integer> listToMap(List<Map<String, Object>> mapList) {
        Map<Integer, Integer> result = new HashMap<>();
        if (CollectionUtil.isNotEmpty(mapList)) {
            for (Map<String, Object> map : mapList) {
                int value = 0;
                //2021-01
                Integer keyMonth = Integer.valueOf(((String) map.get("month")).substring(5));
                if (ObjectUtil.isNotNull(map.get("totalNum")))
                    value = Integer.parseInt(map.get("totalNum").toString());
                if (ObjectUtil.isNotNull(map.get("punctualityNum")))
                    value = Integer.parseInt(map.get("punctualityNum").toString());
                result.put(keyMonth, value);
            }
        }
        return result;
    }


}
