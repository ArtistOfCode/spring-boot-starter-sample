package com.codeartist.component.core.sample.controller;

import com.codeartist.component.core.support.curd.AbstractController;
import com.codeartist.component.core.sample.entity.param.RoleParam;
import com.codeartist.component.core.sample.entity.vo.RoleVO;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色信息 控制器
 *
 * @author CodeGenerator
 * @since 2023-06-29
 */
@Api(tags = "角色信息")
@Validated
@RestController
@RequestMapping("/api/role")
public class RoleController extends AbstractController<RoleVO, RoleParam> {
}
