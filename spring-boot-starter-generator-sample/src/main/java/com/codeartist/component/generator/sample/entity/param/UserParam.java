package com.codeartist.component.generator.sample.entity.param;

import com.codeartist.component.core.entity.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 用户基本信息
 *
 * @author CodeGenerator
 * @since 2023-10-16
 */
@Getter
@Setter
@Schema(description = "用户基本信息")
public class UserParam extends PageParam {

    private Long id;

    @Schema(defaultValue = "真实姓名")
    private String name;

    @Schema(defaultValue = "用户名")
    private String username;

    @Schema(defaultValue = "密码")
    private String password;

    @Schema(defaultValue = "状态：1：删除，0：有效")
    private Integer deleted;

    @Schema(defaultValue = "创建时间")
    private LocalDateTime createTime;
}
