package com.sky.mapper;

import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chake
 * @since 2025/9/8
 */
@Mapper
public interface OrderMapper {
    void insert(Orders order);
}
