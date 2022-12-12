package com.example.backend.pojo.query;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @author 黄磊
 * @since 2022/12/12
 **/
@Data
public class PageQuery {
    @NotNull
    @Range(min = 1,max = 100)
    private Integer currentPage=1;
    @NotNull
    @Range(min = 1,max = 100)
    private Integer pageSize=20;
}
