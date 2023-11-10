package com.codeartist.component.core.sample.entity.param;

import com.codeartist.component.core.entity.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 角色信息
 *
 * @author CodeGenerator
 * @since 2023-06-29
 */
@Getter
@Setter
@ApiModel(description = "角色信息")
public class RoleParam extends PageParam {

    private Long id;

    @ApiModelProperty("真实姓名")
    private String name;
}
