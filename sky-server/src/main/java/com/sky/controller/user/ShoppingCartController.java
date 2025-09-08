package com.sky.controller.user;

import com.sky.context.BaseContext;
import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import com.sky.result.Result;
import com.sky.service.ShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chake
 * @since 2025/9/7
 */
@RequestMapping("/user/shoppingCart")
@RestController
@Api(tags = "购物车相关接口")
@Slf4j
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/add")
    @ApiOperation("新增购物车")
    public Result<Void> add(@RequestBody ShoppingCartDTO dto) {
        log.info("新增购物车：{}", dto);
        shoppingCartService.add(dto);
        return Result.success();
    }

    @GetMapping("/list")
    @ApiOperation("查看购物车")
    public Result<List<ShoppingCart>> list() {
        log.info("查看购物车数据，用户id：{}", BaseContext.getCurrentId());

        List<ShoppingCart> shoppingCartList = shoppingCartService.list();
        return Result.success(shoppingCartList);
    }

    @DeleteMapping("/clean")
    @ApiOperation("清空购物车")
    public Result<Void> clean(){
        log.info("清空购物车");
        shoppingCartService.clean();

        return Result.success();
    }
}
