package com.jeiker.server.service;

import com.jeiker.api.model.ParamModel;
import com.jeiker.api.model.ResultModel;
import com.jeiker.api.service.HelloGenericService;

/**
 * Description: sofa-boot-demo
 * User: jeikerxiao
 * Date: 2019/7/25 4:03 PM
 */
public class HelloGenericServiceImpl implements HelloGenericService {

    @Override
    public ResultModel sayHello(ParamModel paramModel) {
        return new ResultModel(paramModel.getName(), paramModel.getName());
    }

    @Override
    public ResultModel sayHi(ParamModel paramModel) {
        return new ResultModel(paramModel.getName(), paramModel.getName());
    }
}
