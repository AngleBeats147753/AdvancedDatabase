package com.example.backend.dao;

import com.example.backend.pojo.AirportDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 机场信息表 Mapper 接口
 * </p>
 *
 * @author zhoutianlan
 * @since 2022-12-12
 */
@Mapper
public interface AirportDao extends BaseMapper<AirportDO> {

}
