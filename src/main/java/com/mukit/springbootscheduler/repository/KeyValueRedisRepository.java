package com.mukit.springbootscheduler.repository;

import com.mukit.springbootscheduler.entity.KeyValueEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KeyValueRedisRepository {
    private final RedisTemplate<String, String> redisTemplate;

    public void save(KeyValueEntity keyValueEntity) {
        redisTemplate.opsForValue().set(keyValueEntity.getKey(), keyValueEntity.toString());
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
