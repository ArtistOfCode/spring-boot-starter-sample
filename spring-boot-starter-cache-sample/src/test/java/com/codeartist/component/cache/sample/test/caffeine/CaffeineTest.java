package com.codeartist.component.cache.sample.test.caffeine;

import com.codeartist.component.cache.sample.test.bean.Demo;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * 本地缓存测试
 *
 * @author J.N.AI
 * @date 2023/7/14
 */
@Slf4j
public class CaffeineTest {

    /**
     * 手动加载
     */
    Cache<Long, Demo> cache = Caffeine.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .maximumSize(10_000)
            .build();

    /**
     * 自动加载
     */
    LoadingCache<Long, Demo> loadingCache = Caffeine.newBuilder()
            .maximumSize(10_000)
            .refreshAfterWrite(1, TimeUnit.SECONDS)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build(this::getDemo);

    @Test
    void cache() {
        Long key = 1L;
        Demo demo = cache.getIfPresent(key);
        log.info("Cache get {} - {}", key, demo);
        demo = cache.get(key, this::getDemo);
        log.info("Cache get {} - {}", key, demo);
        demo = cache.get(key, this::getDemo);
        log.info("Cache get {} - {}", key, demo);
    }

    @Test
    void loadingCache() {
        Long key = 1L;
        Demo demo = loadingCache.get(key);
        log.info("LoadingCache get {} - {}", key, demo);
    }


    private Demo getDemo(Long id) {
        log.info("Enter service. {}", id);
        Demo demo = new Demo();
        demo.setId(1L);
        demo.setAge(26);
        demo.setName("ajn");
        return demo;
    }
}
