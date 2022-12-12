package com.example.backend.manager.impl;

import com.example.backend.pojo.StateDO;
import com.example.backend.dao.StateDao;
import com.example.backend.manager.StateManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 州信息表 服务实现类
 * </p>
 *
 * @author zhoutianlan
 * @since 2022-12-12
 */
@Service
public class StateManagerImp extends ServiceImpl<StateDao, StateDO> implements StateManager {

}
