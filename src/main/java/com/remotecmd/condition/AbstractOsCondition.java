package com.remotecmd.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;

/**
 * 操作系统Condition的抽象类
 *
 * @author Shuaihang Xue
 * @date 2021/1/23
 */
public abstract class AbstractOsCondition implements Condition {

    protected boolean matchOsName(String osName, ConditionContext context) {
        Environment environment = context.getEnvironment();
        String actualOsName = environment.getProperty("os.name");
        return actualOsName.toLowerCase().contains(osName.toLowerCase());
    }
}
