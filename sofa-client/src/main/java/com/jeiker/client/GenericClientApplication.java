package com.jeiker.client;

import com.alipay.hessian.generic.model.GenericObject;
import com.alipay.sofa.rpc.api.GenericService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * Description: sofa-boot-demo
 * User: jeikerxiao
 * Date: 2019/7/25 4:19 PM
 */
@ImportResource({"classpath*:rpc-client.xml"})
@SpringBootApplication
public class GenericClientApplication {

    public static void main(String[] args) {

        //change port to run in local machine
        System.setProperty("server.port", "8081");

        SpringApplication springApplication = new SpringApplication(GenericClientApplication.class);
        ApplicationContext applicationContext = springApplication.run(args);

        GenericService helloGenericServiceReference = (GenericService) applicationContext
                .getBean("helloGenericServiceReference");

        GenericObject genericObject1 = new GenericObject("com.jeiker.api.model.ParamModel");
        genericObject1.putField("name", "xiao");

        GenericObject genericResult = (GenericObject) helloGenericServiceReference.$genericInvoke(
                "sayHello",
                new String[]{"com.jeiker.api.model.ParamModel"},
                new Object[]{genericObject1});

        GenericObject genericObject2 = new GenericObject("com.jeiker.api.model.ParamModel");
        genericObject2.putField("name", "ri");

        GenericObject genericResult2 = (GenericObject) helloGenericServiceReference.$genericInvoke(
                "sayHi",
                new String[]{"com.jeiker.api.model.ParamModel"},
                new Object[]{genericObject2});

        System.out.println(genericResult.getType());
        System.out.println(genericResult.getField("name"));
        System.out.println(genericResult.getField("value"));

        System.out.println(genericResult2.getField("name"));
        System.out.println(genericResult2.getField("value"));

        String result = (String) genericResult.getField("value");

        System.out.println("invoke result:" + result);

        if ("sample generic value".equalsIgnoreCase(result)) {
            System.out.println("generic invoke success");
        } else {
            System.out.println("generic invoke fail");
        }

    }
}