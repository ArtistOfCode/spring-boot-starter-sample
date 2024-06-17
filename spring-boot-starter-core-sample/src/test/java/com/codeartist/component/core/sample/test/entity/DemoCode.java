package com.codeartist.component.core.sample.test.entity;

import org.springframework.context.MessageSourceResolvable;

/**
 * 测试码
 *
 * @author AiJiangnan
 * @date 2023-11-12
 */
public class DemoCode implements MessageSourceResolvable {

    @Override
    public String[] getCodes() {
        return new String[]{"DEMO_CODE"};
    }

    @Override
    public Object[] getArguments() {
        return MessageSourceResolvable.super.getArguments();
    }

    @Override
    public String getDefaultMessage() {
        return MessageSourceResolvable.super.getDefaultMessage();
    }
}
