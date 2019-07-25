package com.jeiker.api.service;

import com.jeiker.api.model.ParamModel;
import com.jeiker.api.model.ResultModel;

/**
 * Description: sofa-boot-demo
 * User: jeikerxiao
 * Date: 2019/7/25 4:02 PM
 */
public interface HelloGenericService {

    ResultModel sayHello(ParamModel paramModel);

    ResultModel sayHi(ParamModel paramModel);
}
