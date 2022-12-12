package com.example.backend.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.pojo.CityDO;
import com.example.backend.dao.CityDao;
import com.example.backend.manager.CityManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 城市信息表 服务实现类
 * </p>
 *
 * @author zhoutianlan
 * @since 2022-12-12
 */
@Service
public class CityManagerImp extends ServiceImpl<CityDao, CityDO> implements CityManager {


    @Override
    public List<CityDO> listByStateId(Long stateId){
        QueryWrapper<CityDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(CityDO.STATE_ID,stateId);
        return list(queryWrapper);
    }
}
