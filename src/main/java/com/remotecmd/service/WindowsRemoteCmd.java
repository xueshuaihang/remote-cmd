package com.remotecmd.service;

import com.remotecmd.common.Constants;
import com.remotecmd.condition.WindowsConditionAbstract;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * Windows系统的RemoteCmd
 *
 * @author Shuaihang Xue
 * @date 2021/1/22
 */
@Service
@Conditional(WindowsConditionAbstract.class)
public class WindowsRemoteCmd implements RemoteCmd {

    @Override
    public String execute(String cmd) throws IOException {
        cmd = "cmd /c " + cmd;
        Process process = Runtime.getRuntime().exec(cmd);
        InputStream inputStream = process.getInputStream();
        InputStream errorStream = process.getErrorStream();
        String inputStr = getStrForInputStream(inputStream);
        String errorStr = getStrForInputStream(errorStream);
        return "inputStream:"
                + Constants.LINE_SEPARATOR
                + inputStr
                + "errorStream:"
                + Constants.LINE_SEPARATOR
                + errorStr;
    }

    @Override
    public String openChfsAndTimedShutdown() throws IOException {
        return execute("call \"C:\\Users\\hanghang\\Desktop\\open chfs and timed shutdown.bat\"");
    }

    @Override
    public String shutdownInMinute(Integer minute) throws IOException {
        return execute("shutdown /s /t " + minute * 60);
    }

    @Override
    public String shutdownCancel() throws IOException {
        return execute("shutdown /a");
    }

    @Override
    public String shutdownNow() throws IOException {
        return execute("shutdown /s /f");
    }
}
