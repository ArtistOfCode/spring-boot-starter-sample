package com.codeartist.component.core.sample.config;

import com.codeartist.component.core.entity.enums.Constants;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author J.N.AI
 * @date 2023-11-17
 */
@Configuration(proxyBeanMethods = false)
@MapperScan(Constants.ROOT_PACKAGE_KEY + ".mapper")
public class AppConfig {
}
