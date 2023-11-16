package com.codeartist.component.cache.sample.test.redis;

import com.codeartist.component.cache.support.RedisCache;
import com.codeartist.component.core.support.test.AbstractSpringRunnerTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.UUID;

/**
 * 缓存组件测试
 *
 * @author AiJiangnan
 * @date 2021/7/23
 */
public class RedisCacheTemplateTest extends AbstractSpringRunnerTests {

    private final Duration expire = Duration.ofMinutes(3);

    @Autowired
    private RedisCache redisCache;

    @Test
    public void redisStringCache() {
        String key = UUID.randomUUID().toString();
        String val = UUID.randomUUID().toString();

        String result = redisCache.get(key, String.class);
        Assertions.assertNull(result);

        redisCache.set(key, val, expire);
        result = redisCache.get(key, String.class);
        Assertions.assertEquals(val, result);

        redisCache.set(key, null, expire);
        result = redisCache.get(key, String.class);
        Assertions.assertNull(result);

        redisCache.delete(key);

        result = redisCache.get(key, String.class);
        Assertions.assertNull(result);
    }

    @Test
    public void redisHashCache() {
        String key = UUID.randomUUID().toString();
        String hashKey = UUID.randomUUID().toString();
        String val = UUID.randomUUID().toString();

        String result = redisCache.getHash(key, hashKey, String.class);
        Assertions.assertNull(result);

        redisCache.setHash(key, hashKey, val);
        result = redisCache.getHash(key, hashKey, String.class);
        Assertions.assertEquals(val, result);

        redisCache.setHash(key, hashKey, null);
        result = redisCache.getHash(key, hashKey, String.class);
        Assertions.assertNull(result);

        redisCache.delete(key, hashKey);

        result = redisCache.getHash(key, hashKey, String.class);
        Assertions.assertNull(result);
    }

    @Test
    public void redisOther() {
        // Inc
        String key = UUID.randomUUID().toString();
        redisCache.inc(key);
        redisCache.inc(key);
        long inc = redisCache.inc(key);
        Assertions.assertEquals(3, inc);

        // Has
        boolean hasKey = redisCache.exist(key);
        Assertions.assertTrue(hasKey);

        redisCache.expire(key, Duration.ofSeconds(30));

        redisCache.delete(key);

        hasKey = redisCache.exist(key);
        Assertions.assertFalse(hasKey);
    }
}
