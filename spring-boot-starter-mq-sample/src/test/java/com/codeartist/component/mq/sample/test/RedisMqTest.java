package com.codeartist.component.mq.sample.test;

import com.codeartist.component.core.support.mq.bean.MqMessage;
import com.codeartist.component.core.support.mq.bean.MqType;
import com.codeartist.component.core.support.test.AbstractSpringRunnerTests;
import com.codeartist.component.core.util.SpringContext;
import com.codeartist.component.mq.sample.entity.Example;
import com.codeartist.component.mq.sample.entity.Topics;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author J.N.AI
 * @date 2023/7/19
 */
public class RedisMqTest extends AbstractSpringRunnerTests {

    @Test
    void send() throws Exception {
        Example example = new Example();
        example.setName("J.N.AI");
        example.setAge(28L);
        example.setPercent(BigDecimal.TEN);
        example.setCount(0);

        SpringContext.publishEvent(MqMessage.builder()
                .type(MqType.REDIS)
                .topic(Topics.REDIS_TOPIC)
                .body(example)
                .build());

        TimeUnit.SECONDS.sleep(5);
    }
}
