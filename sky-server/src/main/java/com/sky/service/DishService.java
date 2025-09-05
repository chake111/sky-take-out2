package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;

import java.util.List;


/**
 * @author chake
 */
public interface DishService  {

    void addDish(DishDTO dishDTO);

    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    void deleteBatch(List<Long> ids);
}

