package com.codeartist.component.core.sample.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户角色关联信息
 *
 * @author CodeGenerator
 * @since 2023-06-29
 */
@Getter
@Setter
@ApiModel(description = "用户角色关联信息")
public class UserRoleVO {

    private Long id;

    @ApiModelProperty("真实姓名")
    private Long userId;

    @ApiModelProperty("真实姓名")
    private Long roleId;
}
