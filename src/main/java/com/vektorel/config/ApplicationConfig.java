package com.vektorel.config;

import lombok.Getter;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@Getter
@EnableCaching
public class ApplicationConfig {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration("localhost",55001);
        return new JedisConnectionFactory(rsc);
    }

    @Bean
    public RedisTemplate redisTemplate(){
        RedisTemplate temp = new RedisTemplate<>();
        temp.setConnectionFactory(jedisConnectionFactory());
        return temp;
    }
}
