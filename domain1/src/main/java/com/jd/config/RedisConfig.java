package com.jd.config;

import com.jd.common.properties.RedisProperties;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

/**
 * @author Jaedoo Lee
 */
@Configuration
@EnableCaching
@RequiredArgsConstructor
public class RedisConfig {

    private final RedisProperties redisProperties;

    @Bean
    public RedissonClient redissonClient() {
        Config redisConfig = new Config();
        redisConfig.useSingleServer()
                   .setAddress(redisProperties.getHost() + ":" + redisProperties.getPort())
                   .setConnectionPoolSize(5)
                   .setConnectionMinimumIdleSize(5);

        return Redisson.create(redisConfig);
    }

}
