package com.codeartist.component.core.sample.controller;

import com.codeartist.component.core.exception.BadRequestException;
import com.codeartist.component.core.exception.BusinessException;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异常接口测试
 *
 * @author AiJiangnan
 * @date 2022/7/22
 */
@RestController
@RequestMapping("/api/exception")
public class ExceptionController {

    @GetMapping("/client")
    public void client() {
        throw BadRequestException.of("请求异常");
    }

    @GetMapping("/business")
    public void business() {
        throw BusinessException.of("业务异常");
    }

    @GetMapping("/server")
    public void server() {
        throw new RuntimeException("服务器异常");
    }

    @GetMapping("/error")
    public void error() {
        Assert.notNull(null, "不能为空");
    }
}
