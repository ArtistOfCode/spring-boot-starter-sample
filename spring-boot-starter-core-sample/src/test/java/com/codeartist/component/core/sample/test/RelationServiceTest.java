package com.codeartist.component.core.sample.test;

import com.codeartist.component.core.sample.mapper.RoleMapper;
import com.codeartist.component.core.sample.mapper.UserMapper;
import com.codeartist.component.core.sample.service.UserService;
import com.codeartist.component.core.support.test.AbstractSpringRunnerTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 关联关系测试
 *
 * @author J.N.AI
 * @date 2023/6/29
 */
public class RelationServiceTest extends AbstractSpringRunnerTests {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Test
    void relation() {
    }
}
