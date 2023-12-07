package com.yunbok.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    public RedisService(final RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void addKey(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
        } catch (Exception e) {
            log.error("Redis Set Key Error ::: {}", e.getMessage());
        }
    }

    public String getValue(String key) {
        String value = "";
        try {
            if (redisTemplate.hasKey(key)) {
                value = redisTemplate.opsForValue().get(key);
            }
        } catch (Exception e) {
            log.error("### Redis Set Key Error ::: {}", e.getMessage());
        }
        return value;
    }
}
