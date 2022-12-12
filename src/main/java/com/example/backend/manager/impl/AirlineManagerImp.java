package com.example.backend.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.pojo.AirlineDO;
import com.example.backend.dao.AirlineDao;
import com.example.backend.manager.AirlineManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 航线信息表 服务实现类
 * </p>
 *
 * @author zhoutianlan
 * @since 2022-12-12
 */
@Service
public class AirlineManagerImp extends ServiceImpl<AirlineDao, AirlineDO> implements AirlineManager {


    @Override
    public AirlineDO getByAirlineCode(String code){
        QueryWrapper<AirlineDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(AirlineDO.OPERATING_AIRLINE,code);
        return getOne(queryWrapper);
    }
}
