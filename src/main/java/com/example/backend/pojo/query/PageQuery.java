package com.example.backend.pojo.query;

import lombok.Data;

/**
 * @author 黄磊
 * @since 2022/12/12
 **/
@Data
public class PageQuery {
    private Integer currentPage;
    private Integer pageSize;
}
