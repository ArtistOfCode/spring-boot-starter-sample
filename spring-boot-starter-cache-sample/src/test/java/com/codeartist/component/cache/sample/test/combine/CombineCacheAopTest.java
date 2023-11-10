package com.codeartist.component.cache.sample.test.combine;

import com.codeartist.component.cache.sample.entity.Example;
import com.codeartist.component.cache.sample.service.CacheService;
import com.codeartist.component.core.support.test.AbstractSpringRunnerTests;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

import java.math.BigDecimal;

/**
 * 缓存组件测试
 *
 * @author 艾江南
 * @date 2021/7/23
 */
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class CombineCacheAopTest extends AbstractSpringRunnerTests {

    private static final StopWatch stopWatch = new StopWatch();

    @Autowired
    private CacheService combineCacheService;

    @RepeatedTest(5)
    public void combineAopCache() {
        Example example = new Example();
        example.setName("J.N.AI");
        example.setAge(27L);
        example.setPercent(new BigDecimal("100.8"));

        // Cache
        Example cache = combineCacheService.cache(stopWatch);
        Assertions.assertEquals(example, cache);

        Assertions.assertEquals(1, stopWatch.getTaskCount());
    }

    @Test
    public void combineAopDelete() {
        combineCacheService.deleteCache();
    }
}
