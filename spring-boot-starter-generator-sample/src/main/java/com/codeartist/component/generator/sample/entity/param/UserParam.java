package com.codeartist.component.generator.sample.entity.param;

import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import com.codeartist.component.core.entity.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户基本信息
 *
 * @author CodeGenerator
 * @since 2023-12-14
 */
@Getter
@Setter
@Schema(description = "用户基本信息")
public class UserParam extends PageParam {

    private Long id;

    @Schema(description = "真实姓名")
    private String name;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "状态：1：删除，0：有效")
    private Integer deleted;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;
}
