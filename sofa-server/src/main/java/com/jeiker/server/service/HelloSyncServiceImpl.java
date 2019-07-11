package com.jeiker.server.service;

import com.jeiker.api.service.HelloSyncService;

/**
 * Description: 服务端实现
 * User: jeikerxiao
 * Date: 2019/7/11 11:16 AM
 */
public class HelloSyncServiceImpl implements HelloSyncService {

    @Override
    public String saySync(String string) {
        return string;
    }
}
