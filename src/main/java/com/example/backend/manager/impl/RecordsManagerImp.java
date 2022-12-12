package com.example.backend.manager.impl;

import com.example.backend.pojo.RecordsDO;
import com.example.backend.dao.RecordsDao;
import com.example.backend.manager.RecordsManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
