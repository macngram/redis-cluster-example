package com.yunbok.example.controller;


import com.yunbok.example.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    private final RedisService redisService;

    public TestController(final RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/redis/{key}")
    public String get(
            @PathVariable(name = "key") String key
    ) {
        return redisService.getValue(key);
    }
}
