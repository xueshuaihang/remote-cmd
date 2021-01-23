package com.remotecmd.condition;

import com.remotecmd.common.Constants;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Windows操作系统的Condition
 *
 * @author Shuaihang Xue
 * @date 2021/1/23
 */
public class WindowsConditionAbstract extends AbstractOsCondition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return matchOsName(Constants.OS_WINDOWS, context);
    }
}
