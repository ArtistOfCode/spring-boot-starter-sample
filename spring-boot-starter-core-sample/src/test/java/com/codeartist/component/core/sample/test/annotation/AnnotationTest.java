package com.codeartist.component.core.sample.test.annotation;

import com.codeartist.component.core.annotation.AppName;
import com.codeartist.component.core.annotation.RootPackage;
import com.codeartist.component.core.support.test.AbstractSpringRunnerTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 基础注解测试
 *
 * @author AiJiangnan
 * @date 2023-12-11
 */
public class AnnotationTest extends AbstractSpringRunnerTests {

    @AppName
    private String appName;
    @RootPackage
    private String rootPackage;

    @Test
    void annotation() {
        Assertions.assertEquals("core-sample", appName);
        Assertions.assertEquals("com.codeartist.component.core.sample", rootPackage);
    }
}
