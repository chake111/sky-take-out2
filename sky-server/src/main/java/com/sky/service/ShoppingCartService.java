package com.sky.service;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;

import java.util.List;

/**
 * @author chake
 * @since 2025/9/7
 */

public interface ShoppingCartService {
    void add(ShoppingCartDTO dto);

    List<ShoppingCart> list();

    void clean();
}
