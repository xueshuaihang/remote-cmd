package com.remotecmd.service;

import com.remotecmd.condition.LinuxCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Linux系统的RemoteCmd
 *
 * @author Shuaihang Xue
 * @date 2021/1/23
 */
@Service
@Conditional(LinuxCondition.class)
public class LinuxRemoteCmd implements RemoteCmd {
    @Override
    public String execute(String cmd) throws IOException {
        return null;
    }

    @Override
    public String shutdownInMinute(Integer minute) throws IOException {
        return null;
    }

    @Override
    public String shutdownNow() throws IOException {
        return null;
    }

    @Override
    public String shutdownCancel() throws IOException {
        return null;
    }

    @Override
    public String openChfsAndTimedShutdown() throws IOException {
        return null;
    }
}
