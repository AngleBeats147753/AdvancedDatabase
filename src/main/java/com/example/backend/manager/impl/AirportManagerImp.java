package com.example.backend.manager.impl;

import com.example.backend.pojo.AirportDO;
import com.example.backend.dao.AirportDao;
import com.example.backend.manager.AirportManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 机场信息表 服务实现类
 * </p>
 *
 * @author zhoutianlan
 * @since 2022-12-12
 */
@Service
public class AirportManagerImp extends ServiceImpl<AirportDao, AirportDO> implements AirportManager {

}
