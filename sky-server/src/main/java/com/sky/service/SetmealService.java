package com.sky.service;

import com.sky.entity.Setmeal;
import com.sky.vo.DishItemVO;

import java.util.List;

/**
 * @author chake
 */
public interface SetmealService {

    /**
     * 条件查询
     */
    List<Setmeal> list(Setmeal setmeal);

    /**
     * 根据id查询菜品选项
     */
    List<DishItemVO> getDishItemById(Long id);

}
