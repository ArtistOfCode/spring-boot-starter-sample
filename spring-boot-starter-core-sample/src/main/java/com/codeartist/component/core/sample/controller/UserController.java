package com.codeartist.component.core.sample.controller;

import com.codeartist.component.core.entity.Relation;
import com.codeartist.component.core.sample.entity.RelationEnum;
import com.codeartist.component.core.sample.entity.param.UserParam;
import com.codeartist.component.core.sample.entity.vo.UserVO;
import com.codeartist.component.core.support.curd.AbstractController;
import com.codeartist.component.core.support.curd.RelationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 用户基本信息 控制器
 *
 * @author CodeGenerator
 * @since 2023-06-29
 */
@Tag(name = "UserController", description = "用户基本信息")
@Validated
@RestController
@RequestMapping("/api/user")
public class UserController extends AbstractController<UserVO, UserParam> {

    @Autowired
    private RelationService relationService;

    @GetMapping("/role")
    @ApiOperation("查询关联信息")
    public Relation relation(@NotNull Long id) {
        return relationService.getRelation(RelationEnum.USER_ROLE.getRel(), id);
    }

    @PostMapping("/role")
    @ApiOperation("保存关联接口")
    public void relation(@Valid @RequestBody Relation param) {
        relationService.saveRelation(RelationEnum.USER_ROLE.getRel(), param);
    }
}
