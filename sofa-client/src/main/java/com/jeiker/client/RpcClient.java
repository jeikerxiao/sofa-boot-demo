package com.jeiker.client;

import com.alipay.sofa.rpc.config.ConsumerConfig;
import com.jeiker.api.service.HelloSyncService;

/**
 * Description: sofa-boot-demo
 * User: jeikerxiao
 * Date: 2019/7/11 11:39 AM
 */
public class RpcClient {

    public static void main(String[] args) {
        ConsumerConfig<HelloSyncService> consumerConfig = new ConsumerConfig<HelloSyncService>()
                .setInterfaceId(HelloSyncService.class.getName()) // 指定接口
                .setProtocol("bolt") // 指定协议
                .setDirectUrl("bolt://127.0.0.1:8080") // 指定直连地址
                .setConnectTimeout(10 * 1000);

        HelloSyncService helloService = consumerConfig.refer();

        while (true) {
            try {
                System.out.println(helloService.saySync("Hello"));
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
