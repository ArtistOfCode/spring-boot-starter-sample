package com.codeartist.component.cache.sample.test.caffeine;

import com.codeartist.component.cache.support.caffeine.LocalCacheTemplate;
import com.codeartist.component.core.support.test.AbstractSpringRunnerTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * 缓存组件测试
 *
 * @author 艾江南
 * @date 2021/7/23
 */
public class CaffeineCacheTemplateTest extends AbstractSpringRunnerTests {

    @Autowired
    private LocalCacheTemplate localCacheTemplate;

    @Test
    public void redisStringCache() {
        String key = UUID.randomUUID().toString();
        String val = UUID.randomUUID().toString();

        String result = localCacheTemplate.get(key, String.class);
        Assertions.assertNull(result);

        localCacheTemplate.set(key, val);
        result = localCacheTemplate.get(key, String.class);
        Assertions.assertEquals(val, result);

        localCacheTemplate.set(key, null);
        result = localCacheTemplate.get(key, String.class);
        Assertions.assertNull(result);

        localCacheTemplate.delete(key);

        result = localCacheTemplate.get(key, String.class);
        Assertions.assertNull(result);
    }
}
