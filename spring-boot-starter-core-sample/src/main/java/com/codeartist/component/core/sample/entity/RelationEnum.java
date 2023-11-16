package com.codeartist.component.core.sample.entity;

import com.codeartist.component.core.entity.Rel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author AiJiangnan
 * @date 2023-10-08
 */
@Getter
@RequiredArgsConstructor
public enum RelationEnum {

    USER_ROLE(Rel.of(UserRole.class, "user_id", "role_id"));

    private final Rel<?> rel;
}
