package com.codeartist.component.cache.sample.test.bean;

import lombok.Builder;
import lombok.Data;

/**
 * 测试类
 *
 * @author AiJiangnan
 * @date 2023/7/14
 */
@Data
@Builder
public class Demo {
    private Long id;
    private Integer age;
    private String name;
}
