package com.codeartist.component.cache.sample.service;

import com.codeartist.component.cache.sample.entity.Example;
import com.codeartist.component.cache.sample.entity.GenericExample;
import com.codeartist.component.core.support.cache.annotation.Cache;
import com.codeartist.component.core.support.cache.annotation.CacheDelete;
import com.codeartist.component.core.support.cache.annotation.LocalCache;
import com.codeartist.component.core.support.cache.annotation.LocalCacheDelete;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 艾江南
 * @date 2022/8/18
 */
@Service
public class CombineCacheService implements CacheService {

    @Override
    @LocalCache(key = CACHE_KEY)
    @Cache(key = CACHE_KEY, timeout = 3, timeUnit = TimeUnit.MINUTES)
    public synchronized Example cache(StopWatch stopWatch) {
        stopWatch.start(UUID.randomUUID().toString());
        Example example = new Example();
        example.setName("J.N.AI");
        example.setAge(27L);
        example.setPercent(new BigDecimal("100.8"));
        stopWatch.stop();
        return example;
    }

    @Override
    @LocalCache(key = GENERIC_CACHE_KEY)
    public synchronized GenericExample<Example> genericCache(StopWatch stopWatch) {
        stopWatch.start(UUID.randomUUID().toString());
        Example example = new Example();
        example.setName("J.N.AI");
        example.setAge(27L);
        example.setPercent(new BigDecimal("100.8"));
        GenericExample<Example> genericExample = new GenericExample<>();
        genericExample.setName(example.getName());
        genericExample.setData(example);
        stopWatch.stop();
        return genericExample;
    }

    @Override
    @LocalCache(key = SPEL_CACHE_KEY, spel = "#id")
    public synchronized Example spelCache(Long id, StopWatch stopWatch) {
        stopWatch.start(UUID.randomUUID().toString());
        Example example2 = new Example();
        example2.setName("J.N.AI");
        example2.setAge(26L);
        Example example = new Example();
        example.setName("J.N.AI");
        example.setAge(27L);
        example.setPercent(new BigDecimal("100.8"));
        example.setExample(example2);
        stopWatch.stop();
        return example;
    }

    @Override
    @LocalCache(key = NULL_CACHE_KEY)
    public synchronized Example nullCache(StopWatch stopWatch) {
        stopWatch.start(UUID.randomUUID().toString());
        stopWatch.stop();
        return null;
    }

    @Override
    @CacheDelete(key = CACHE_KEY)
    @LocalCacheDelete(key = CACHE_KEY)
    public synchronized void deleteCache() {
    }

    @Override
    @LocalCacheDelete(key = GENERIC_CACHE_KEY)
    public synchronized void deleteGenericCache() {
    }

    @Override
    @LocalCacheDelete(key = SPEL_CACHE_KEY, spel = "#id")
    public synchronized void deleteSpelCache(Long id) {
    }

    @Override
    @LocalCacheDelete(key = NULL_CACHE_KEY)
    public synchronized void deleteNullCache() {
    }
}
