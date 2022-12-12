package com.example.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 州信息表
 * </p>
 *
 * @author zhoutianlan
 * @since 2022-12-12
 */
@Data
@TableName("state")
public class StateDO implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String ID = "id";
    public static final String STATE_NAME = "state_name";
    public static final String STATE_CODE = "state_code";

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 州名称
     */
    @TableField("state_name")
    private String stateName;

    /**
     * 州缩写
     */
    @TableField("state_code")
    private String stateCode;


}
