package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

/**
 * @author chake
 * @since 2025/9/5
 */

public interface UserService {
    User wxLogin(UserLoginDTO userLoginDTO);
}
