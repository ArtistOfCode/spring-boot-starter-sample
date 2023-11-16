package com.codeartist.component.cache.sample.test.localcache;

import com.codeartist.component.cache.sample.test.bean.Demo;
import com.codeartist.component.cache.support.LocalCache;
import com.codeartist.component.core.support.test.AbstractSpringRunnerTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * Caffeine本地缓存测试
 *
 * @author J.N.AI
 * @date 2023-11-16
 */
public class CaffeineCacheTest extends AbstractSpringRunnerTests {

    @Autowired
    private LocalCache localCache;

    @Test
    public void get() {
        String key = UUID.randomUUID().toString();
        String value = UUID.randomUUID().toString();
        // get -> set -> get -> del -> get
        String data = localCache.get(key);
        Assertions.assertNull(data);
    }

    public void getValueLoader() {
    }

    public void set() {
    }

    public void delete() {
    }

    private Demo doBusiness() {
        return Demo.builder()
                .id(1L)
                .name("AiJiangnan")
                .age(28)
                .build();
    }
}
