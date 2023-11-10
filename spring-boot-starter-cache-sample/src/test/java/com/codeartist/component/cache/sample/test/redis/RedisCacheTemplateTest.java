package com.codeartist.component.cache.sample.test.redis;

import com.codeartist.component.cache.support.RedisCacheTemplate;
import com.codeartist.component.core.support.test.AbstractSpringRunnerTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.UUID;

/**
 * 缓存组件测试
 *
 * @author 艾江南
 * @date 2021/7/23
 */
public class RedisCacheTemplateTest extends AbstractSpringRunnerTests {

    private final Duration expire = Duration.ofMinutes(3);

    @Autowired
    private RedisCacheTemplate defaultRedisCacheTemplate;

    @Test
    public void redisStringCache() {
        String key = UUID.randomUUID().toString();
        String val = UUID.randomUUID().toString();

        String result = defaultRedisCacheTemplate.get(key, String.class);
        Assertions.assertNull(result);

        defaultRedisCacheTemplate.set(key, val, expire);
        result = defaultRedisCacheTemplate.get(key, String.class);
        Assertions.assertEquals(val, result);

        defaultRedisCacheTemplate.set(key, null, expire);
        result = defaultRedisCacheTemplate.get(key, String.class);
        Assertions.assertNull(result);

        defaultRedisCacheTemplate.delete(key);

        result = defaultRedisCacheTemplate.get(key, String.class);
        Assertions.assertNull(result);
    }

    @Test
    public void redisHashCache() {
        String key = UUID.randomUUID().toString();
        String hashKey = UUID.randomUUID().toString();
        String val = UUID.randomUUID().toString();

        String result = defaultRedisCacheTemplate.get(key, hashKey, String.class);
        Assertions.assertNull(result);

        defaultRedisCacheTemplate.set(key, hashKey, expire, val);
        result = defaultRedisCacheTemplate.get(key, hashKey, String.class);
        Assertions.assertEquals(val, result);

        defaultRedisCacheTemplate.set(key, hashKey, expire, null);
        result = defaultRedisCacheTemplate.get(key, hashKey, String.class);
        Assertions.assertNull(result);

        defaultRedisCacheTemplate.delete(key, hashKey);

        result = defaultRedisCacheTemplate.get(key, hashKey, String.class);
        Assertions.assertNull(result);
    }

    @Test
    public void redisOther() {
        // Inc
        String key = UUID.randomUUID().toString();
        defaultRedisCacheTemplate.inc(key);
        defaultRedisCacheTemplate.inc(key);
        long inc = defaultRedisCacheTemplate.inc(key);
        Assertions.assertEquals(3, inc);

        // Has
        boolean hasKey = defaultRedisCacheTemplate.exist(key);
        Assertions.assertTrue(hasKey);

        defaultRedisCacheTemplate.expire(key, Duration.ofSeconds(30));

        defaultRedisCacheTemplate.delete(key);

        hasKey = defaultRedisCacheTemplate.exist(key);
        Assertions.assertFalse(hasKey);
    }
}
