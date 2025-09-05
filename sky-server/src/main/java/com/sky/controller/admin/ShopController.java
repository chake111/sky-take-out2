package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author chake
 * @since 2025/9/5
 */
@Getter
@RequestMapping("/admin/shop")
@RestController("adminShopController")
@Slf4j
@Api(tags = "店铺相关接口")
public class ShopController {

    private final StringRedisTemplate redisTemplate;
    private final String KEY = "SHOP_STATUS";

    public ShopController(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PutMapping("/{status}")
    @ApiOperation("设置店铺状态")
    public Result<Void> setStatus(@PathVariable Integer status) {
        log.info("设置店铺状态为：{}", status == 1 ? "营业中" : "打烊中");
        redisTemplate.opsForValue().set(KEY, String.valueOf(status));
        return Result.success();
    }

    @GetMapping("/status")
    @ApiOperation("获取店铺的营业状态")
    public Result<Integer> getStatus(){
        int status = Integer.parseInt(Objects.requireNonNull(redisTemplate.opsForValue().get(KEY)));
        log.info("获取到店铺的营业状态为：{}",status == 1 ? "营业中" : "打烊中");
        return Result.success(status);
    }
}
