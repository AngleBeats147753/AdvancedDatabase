package com.example.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 航线信息表
 * </p>
 *
 * @author zhoutianlan
 * @since 2022-12-12
 */
@Data
@TableName("airline")
public class AirlineDO implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String ID = "id";
    public static final String AIRLINE = "airline";
    public static final String OPERATING_AIRLINE = "operating_airline";

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 航空公司
     */
    @TableField("airline")
    private String airline;

    /**
     * 航线代码
     */
    @TableField("operating_airline")
    private String operatingAirline;


}
