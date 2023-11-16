package com.codeartist.component.cache.sample.test.caffeine;

import com.codeartist.component.cache.sample.entity.Example;
import com.codeartist.component.cache.sample.entity.GenericExample;
import com.codeartist.component.cache.sample.service.CacheService;
import com.codeartist.component.core.support.test.AbstractSpringRunnerTests;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

import java.math.BigDecimal;

/**
 * 缓存组件测试
 *
 * @author AiJiangnan
 * @date 2021/7/23
 */
@TestMethodOrder(MethodOrderer.class)
public class CaffeineCacheAopTest extends AbstractSpringRunnerTests {

    private static final StopWatch stopWatch = new StopWatch();

    @Autowired
    private CacheService localCacheService;

    @RepeatedTest(5)
    public void localAopCache(RepetitionInfo info) {
        final int count = 4;

        Example example = new Example();
        example.setName("AiJiangnan");
        example.setAge(27L);
        example.setPercent(new BigDecimal("100.8"));

        // Cache
        Example cache1 = localCacheService.cache(stopWatch);
        Assertions.assertEquals(example, cache1);

        int expected = info.getCurrentRepetition() == 1 ? 1 : count;
        Assertions.assertEquals(expected, stopWatch.getTaskCount());

        // Cache
        GenericExample<Example> cache2 = localCacheService.genericCache(stopWatch);
        Assertions.assertEquals(example.getClass(), cache2.getData().getClass());
        Assertions.assertEquals(example, cache2.getData());

        expected = info.getCurrentRepetition() == 1 ? 2 : count;
        Assertions.assertEquals(expected, stopWatch.getTaskCount());

        // Cache SpEL
        Example cache3 = localCacheService.spelCache(1L, stopWatch);
        Assertions.assertEquals(example.getClass(), cache3.getExample().getClass());
        Assertions.assertNotEquals(example, cache3);

        expected = info.getCurrentRepetition() == 1 ? 3 : count;
        Assertions.assertEquals(expected, stopWatch.getTaskCount());

        // Cache Breakdown
        Example nullCache = localCacheService.nullCache(stopWatch);

        Assertions.assertNull(nullCache);
        Assertions.assertEquals(count, stopWatch.getTaskCount());
    }

    @Test
    public void localAopDelete() {
        localCacheService.deleteCache();
        localCacheService.deleteGenericCache();
        localCacheService.deleteSpelCache(1L);
        localCacheService.deleteNullCache();
    }
}
