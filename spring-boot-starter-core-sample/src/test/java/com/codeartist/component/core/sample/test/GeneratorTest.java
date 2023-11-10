package com.codeartist.component.core.sample.test;

import com.codeartist.component.generator.GenerateUtils;
import com.codeartist.component.generator.engine.EnhanceH2Query;
import com.codeartist.component.generator.entity.GenerateProperties;
import org.junit.jupiter.api.Test;

/**
 * 代码生成单元测试
 *
 * @author J.N.AI
 * @date 2023/6/12
 */
public class GeneratorTest {

    @Test
    void generate() {
        GenerateProperties prop = new GenerateProperties();
        prop.setDbQuery(new EnhanceH2Query());
        prop.setPackageName("com.codeartist.component.core.sample");
        prop.setTables("t_user", "t_role", "t_user_role");
        GenerateUtils.generate(prop);
    }
}
