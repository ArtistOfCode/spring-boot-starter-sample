package com.codeartist.component.cache.sample.test.service;

import com.codeartist.component.cache.sample.service.CacheService;
import com.codeartist.component.core.support.test.AbstractSpringRunnerTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;


/**
 * @author J.N.AI
 * @date 2023-12-01
 */
class RedisCacheServiceTest extends AbstractSpringRunnerTests {

    private static final StopWatch stopWatch = new StopWatch();

    @Autowired
    private CacheService redisCacheService;

    @Test
    void cache() {
        redisCacheService.cache(stopWatch);
    }
}