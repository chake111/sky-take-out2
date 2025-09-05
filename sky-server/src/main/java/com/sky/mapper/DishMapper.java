package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author chake
 */
@Mapper
public interface DishMapper {

    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    @AutoFill
    void addDish(Dish dish);

    Page<DishVO> pageQuery(DishPageQueryDTO dto);

    @Select("select * from dish where id = #{id}")
    Dish getById(Long id);

    @Delete("delete from dish where id = #{id}")
    void deleteById(Long id);
}
