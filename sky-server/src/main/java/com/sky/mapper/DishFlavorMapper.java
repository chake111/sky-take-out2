package com.sky.mapper;
import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author chake
 */
@Mapper
public interface DishFlavorMapper {

    @Insert("insert into dish_flavor(id, dish_id, name, value) values (default,#{dishId},#{name},#{value})")
    void add(DishFlavor dishFlavor);
}

