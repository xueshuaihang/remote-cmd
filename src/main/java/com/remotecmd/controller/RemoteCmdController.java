package com.remotecmd.controller;

import com.remotecmd.service.RemoteCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 入口Controller
 *
 * @author Shuaihang Xue
 * @date 2021/1/22
 */
@RestController
@RequestMapping("/cmd")
public class RemoteCmdController {

    @Autowired
    private RemoteCmd remoteCmd;

    /**
     * 测试连通性
     *
     * @return success
     */
    @GetMapping("/ping")
    public String ping() {
        return "success";
    }

    @GetMapping
    public String execute(String cmd) throws IOException {
        return remoteCmd.execute(cmd);
    }

    @GetMapping("/hi")
    public String openChfsAndTimedShutdown() throws IOException {
        return remoteCmd.openChfsAndTimedShutdown();
    }

    @GetMapping("/shutdown/{minute}")
    public String shutdownInMinute(@PathVariable Integer minute) throws IOException {
        return remoteCmd.shutdownInMinute(minute);
    }

    @GetMapping("/shutdownCancel")
    public String shutdownCancel() throws IOException {
        return remoteCmd.shutdownCancel();
    }

    @GetMapping("/shutdownNow")
    public String shutdownNow() throws IOException {
        return remoteCmd.shutdownNow();
    }
}
