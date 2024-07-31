package com.mukit.springbootscheduler.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@Builder
@RedisHash("keyValue")
public class KeyValueEntity implements Serializable {
    private String key;
    private String value;
}
