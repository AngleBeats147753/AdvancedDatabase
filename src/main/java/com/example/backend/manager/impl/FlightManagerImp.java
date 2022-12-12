package com.example.backend.manager.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 航班表 服务实现类
 * </p>
 *
 * @author zhoutianlan
 * @since 2022-12-12
 */
@Service
public class FlightManagerImp extends ServiceImpl<FlightDao, FlightDO> implements IService<FlightDO> {

}
