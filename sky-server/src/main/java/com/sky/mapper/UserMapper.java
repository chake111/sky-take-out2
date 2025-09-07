package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author chake
 * @since 2025/9/7
 */
@Mapper
public interface UserMapper {
    
    @Select("select * from user where openid=openid")
    User getByOpenid(String openid);

    void insert(User user);
}
