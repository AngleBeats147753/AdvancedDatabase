package com.example.backend.dao;

import com.example.backend.pojo.AirlineDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 航线信息表 Mapper 接口
 * </p>
 *
 * @author zhoutianlan
 * @since 2022-12-12
 */
@Mapper
public interface AirlineDao extends BaseMapper<AirlineDO> {

}
