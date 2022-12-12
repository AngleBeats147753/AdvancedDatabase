package com.example.backend.pojo.dto;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * @author 黄磊
 * @since 2022/9/14
 **/
public class PageDTO<T> extends Page<T> {
    public PageDTO() {
    }

    public PageDTO(long current, long size) {
        super(current, size);
    }

    public PageDTO(long current, long size, long total) {
        super(current, size, total);
    }

    public PageDTO(long current, long size, boolean searchCount) {
        super(current, size, searchCount);
    }

    public PageDTO(long current, long size, long total, boolean searchCount) {
        super(current, size, total, searchCount);
    }

    public PageDTO(long size, long total, List<T> records) {
        this.size = size;
        this.total = total;
        this.records = records;
    }

    @Override
    @JsonIgnore
    public long getTotal() {
        return super.getTotal();
    }

    @Override
    @JsonIgnore
    public long getSize() {
        return super.getSize();
    }

    @Override
    @JsonIgnore
    public long getCurrent() {
        return super.getCurrent();
    }

    @Override
    @Deprecated
    @JsonIgnore
    public String getCountId() {
        return this.countId;
    }

    @Override
    @Deprecated
    @JsonIgnore
    public Long getMaxLimit() {
        return this.maxLimit;
    }

    @Override
    @Deprecated
    @JsonIgnore
    public List<OrderItem> getOrders() {
        return this.orders;
    }

    @Override
    @Deprecated
    @JsonIgnore
    public boolean isOptimizeCountSql() {
        return this.optimizeCountSql;
    }

    @Override
    @Deprecated
    @JsonIgnore
    public boolean isSearchCount() {
        return this.searchCount;
    }
}
