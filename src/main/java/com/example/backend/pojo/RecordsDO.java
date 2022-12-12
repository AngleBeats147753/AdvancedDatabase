package com.example.backend.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * <p>
 * 航班信息表
 * </p>
 *
 * @author zhoutianlan
 * @since 2022-12-12
 */
@Data
@TableName("records")
public class RecordsDO implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String ID = "id";
    public static final String FLIGHT_DATE = "flight_date";
    public static final String FLIGHT_NUMBER_OPERATING_AIRLINE = "flight_number_operating_airline";
    public static final String ORIGIN_AIRPORT_ID = "origin_airport_id";
    public static final String AIRLINE_ID = "airline_id";
    public static final String DEST_AIRPORT_ID = "dest_airport_id";
    public static final String CANCELLED = "cancelled";
    public static final String CRSDEPTIME = "CRSDepTime";
    public static final String DEPTIME = "DepTime";
    public static final String DEPDELAY = "DepDelay";
    public static final String ARRTIME = "ArrTime";
    public static final String CRSARRTIME = "CRSArrTime";
    public static final String ARRDELAY = "ArrDelay";

    @TableField("id")
    private Long id;

    /**
     * 飞行日期
     */
    @TableField("flight_date")
    private LocalDateTime flightDate;

    /**
     * 航班号
     */
    @TableField("flight_number_operating_airline")
    private Integer flightNumberOperatingAirline;

    /**
     * 起始机场id
     */
    @TableField("origin_airport_id")
    private Long originAirportId;

    /**
     * 航空公司ID
     */
    @TableField("airline_id")
    private Long airlineId;

    /**
     * 终点机场id
     */
    @TableField("dest_airport_id")
    private Long destAirportId;

    /**
     * 是否取消
     */
    @TableField("cancelled")
    private Integer cancelled;

    @TableField("CRSDepTime")
    private Double cRSDepTime;

    @TableField("DepTime")
    private Double depTime;

    @TableField("DepDelay")
    private Double depDelay;

    @TableField("ArrTime")
    private Double arrTime;

    @TableField("CRSArrTime")
    private Double cRSArrTime;

    @TableField("ArrDelay")
    private Double arrDelay;


}
