package com.lifengming.client.handlers;

import com.lifengming.client.beans.MethodInfo;
import com.lifengming.client.beans.ServerInfo;

/**
 * @author lifengming
 * @date 2021.01.03
 */
public interface RestHandler {
    /**
     *初始化服务器信息
     * @param serverInfo /
     */
    void init(ServerInfo serverInfo);


    /**
     *调用rest请求，返回接口
     * @param methodInfo /
     * @return /
     */
    Object invokeRest(MethodInfo methodInfo);

}
