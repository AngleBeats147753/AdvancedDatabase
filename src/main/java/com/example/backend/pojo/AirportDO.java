package com.example.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 机场信息表
 * </p>
 *
 * @author zhoutianlan
 * @since 2022-12-12
 */
@Data
@TableName("airport")
public class AirportDO implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String ID = "id";
    public static final String AIRPORT_ID_CODE = "airport_id_code";
    public static final String AIRPORT_CODE = "airport_code";
    public static final String CITY_ID = "city_id";

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("airport_id_code")
    private Long airportIdCode;

    @TableField("airport_code")
    private String airportCode;

    @TableField("city_id")
    private Long cityId;


}
