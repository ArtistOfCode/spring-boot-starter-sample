package com.codeartist.component.core.sample.service.checker;

import com.codeartist.component.core.sample.entity.User;
import com.codeartist.component.core.sample.entity.param.UserParam;
import com.codeartist.component.core.support.curd.EntityChecker;
import com.codeartist.component.core.support.curd.EntityContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 用户检查
 *
 * @author AiJiangnan
 * @date 2023-12-12
 */
@Component
public class UserChecker implements EntityChecker<EntityContext<UserParam, User>, UserParam, User> {

    @Override
    public void checkSave(EntityContext<UserParam, User> context) {
        if (StringUtils.isEmpty(context.getParam().getName())) {
            context.getErrorResolver().rejectClient("用户名不能为空");
        }
    }
}
