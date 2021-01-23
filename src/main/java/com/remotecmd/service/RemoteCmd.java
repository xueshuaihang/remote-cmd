package com.remotecmd.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * RemoteCmd接口
 *
 * @author Shuaihang Xue
 * @date 2021/1/23
 */
public interface RemoteCmd {

    /**
     * 执行命令
     *
     * @param cmd 命令
     * @return 输出的结果
     * @throws IOException IOException
     */
    String execute(String cmd) throws IOException;

    /**
     * 定时关机，以分钟为单位
     *
     * @param minute 多少分钟后关机
     * @return 输出的结果
     * @throws IOException IOException
     */
    String shutdownInMinute(Integer minute) throws IOException;

    /**
     * 马上关机
     *
     * @return 输出的结果
     * @throws IOException IOException
     */
    String shutdownNow() throws IOException;

    /**
     * 取消定时关机
     *
     * @return 输出的结果
     * @throws IOException IOException
     */
    String shutdownCancel() throws IOException;

    /**
     * 打开chfs并且定时关机
     *
     * @return 输出的结果
     * @throws IOException IOException
     */
    String openChfsAndTimedShutdown() throws IOException;

    /**
     * 获取InputStream中的内容
     *
     * @param inputStream inputStream
     * @return InputStream中的内容
     * @throws IOException IOException
     */
    default String getStrForInputStream(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("GBK")));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        return stringBuilder.toString();
    }
}
