package com.jeiker.server;

import com.alipay.sofa.rpc.config.ProviderConfig;
import com.alipay.sofa.rpc.config.ServerConfig;
import com.jeiker.api.service.HelloSyncService;
import com.jeiker.server.service.HelloSyncServiceImpl;

/**
 * Description: sofa-boot-demo
 * User: jeikerxiao
 * Date: 2019/7/11 11:55 AM
 */
public class RpcServer {

    public static void main(String[] args) {
        ServerConfig serverConfig = new ServerConfig()
                .setProtocol("bolt") // 设置一个协议，默认bolt
                .setPort(8080) // 设置一个端口，默认12200
                .setDaemon(false); // 非守护线程

        ProviderConfig<HelloSyncService> providerConfig = new ProviderConfig<HelloSyncService>()
                .setInterfaceId(HelloSyncService.class.getName()) // 指定接口
                .setRef(new HelloSyncServiceImpl()) // 指定实现
                .setServer(serverConfig); // 指定服务端

        providerConfig.export(); // 发布服务
    }
}
