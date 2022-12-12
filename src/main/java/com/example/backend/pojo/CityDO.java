package com.example.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 城市信息表
 * </p>
 *
 * @author zhoutianlan
 * @since 2022-12-12
 */
@Data
@TableName("city")
public class CityDO implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String ID = "id";
    public static final String CITY_NAME = "city_name";
    public static final String STATE_ID = "state_id";

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 城市名称
     */
    @TableField("city_name")
    private String cityName;

    /**
     * 所属州ID
     */
    @TableField("state_id")
    private Long stateId;


}
