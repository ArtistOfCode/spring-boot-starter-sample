package com.codeartist.component.cache.sample.test.caffeine;

import com.codeartist.component.cache.support.caffeine.CaffeineCache;
import com.codeartist.component.core.support.test.AbstractSpringRunnerTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * 缓存组件测试
 *
 * @author AiJiangnan
 * @date 2021/7/23
 */
public class CaffeineCacheTemplateTest extends AbstractSpringRunnerTests {

    @Autowired
    private CaffeineCache caffeineCache;

    @Test
    public void redisStringCache() {
        String key = UUID.randomUUID().toString();
        String val = UUID.randomUUID().toString();

        String result = caffeineCache.get(key);
        Assertions.assertNull(result);

        caffeineCache.set(key, val);
        result = caffeineCache.get(key);
        Assertions.assertEquals(val, result);

        caffeineCache.set(key, null);
        result = caffeineCache.get(key);
        Assertions.assertNull(result);

        caffeineCache.delete(key);

        result = caffeineCache.get(key);
        Assertions.assertNull(result);
    }
}
