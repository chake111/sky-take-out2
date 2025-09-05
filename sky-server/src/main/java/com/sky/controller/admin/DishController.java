package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author chake
 */
@RestController
@Api(tags = "菜品相关接口")
@Slf4j
@CrossOrigin
@RequestMapping("/admin/dish")
public class DishController {
    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping
    @ApiOperation("新增菜品")
    public Result<Void> addDish(@RequestBody DishDTO dishDTO) {
        log.info("新增菜品：{}", dishDTO);
        dishService.addDish(dishDTO);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation("分页查询菜品")
    public Result<PageResult> page(DishPageQueryDTO dto) {
        log.info("分页查询菜品：{}", dto);
        PageResult pageResult = dishService.pageQuery(dto);
        return Result.success(pageResult);
    }

    @DeleteMapping
    @ApiOperation("批量删除菜品")
     public Result<Void> delete(@RequestParam List<Long> ids) {
        log.info("批量删除菜品:{}", ids);
        dishService.deleteBatch(ids);
        return Result.success();
    }
}

