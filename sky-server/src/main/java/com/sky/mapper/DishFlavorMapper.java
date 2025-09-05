package com.sky.mapper;
import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @author chake
 */
@Mapper
public interface DishFlavorMapper {

    @Insert("insert into dish_flavor(id, dish_id, name, value) values (default,#{dishId},#{name},#{value})")
    void add(DishFlavor dishFlavor);

    @Delete("delete from dish_flavor where dish_id = #{dishId}")
    void deleteByDishId(Long dishId);

    @Select("select * from dish_flavor where dish_id = #{dishId}")
    List<DishFlavor> getByDishId(Long dishId);

    void insertBatch(List<DishFlavor> flavorList);
}

