package com.codeartist.component.core.sample.test.code;

import com.codeartist.component.core.sample.test.AbstractSpringWebRunnerTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * 错误码测试
 *
 * @author AiJiangnan
 * @date 2023-12-11
 */
public class ErrorCodeTest extends AbstractSpringWebRunnerTests {

    @Autowired
    private MessageSource messageSource;

    @Test
    void errorCode() {
        String defaultCode = messageSource.getMessage("test.code", null, "defaultCode", Locale.getDefault());
        logger.info(defaultCode);
    }
}
