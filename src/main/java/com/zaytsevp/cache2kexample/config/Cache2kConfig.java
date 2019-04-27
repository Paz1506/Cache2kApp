package com.zaytsevp.cache2kexample.config;

import org.cache2k.extra.spring.SpringCache2kCacheManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Конфигурация для кеша
 *
 * @author Pavel Zaytsev
 */
@Configuration
@EnableCaching
public class Cache2kConfig {

    @Bean
    public CacheManager cacheManager(@Value("${cache.autos.expire-seconds}") long autoCacheExpireSeconds) {
        SpringCache2kCacheManager cacheManager = new SpringCache2kCacheManager()
                .defaultSetup(b -> b.entryCapacity(1000));

        if (!cacheManager.getCacheNames().contains("autos")) {
            cacheManager.addCaches(b -> b.name("autos").expireAfterWrite(autoCacheExpireSeconds, SECONDS));
        }

        return cacheManager;
    }
}
