package com.jeiker.client;

import com.alipay.hessian.generic.model.GenericObject;
import com.alipay.sofa.rpc.api.GenericService;
import com.jeiker.api.service.HelloSyncService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:rpc-client.xml"})
public class SofaClientApplication {

    public static void main(String[] args) {
//		SpringApplication.run(SofaClientApplication.class, args);

        SpringApplication springApplication = new SpringApplication(SofaClientApplication.class);
        ApplicationContext applicationContext = springApplication.run(args);

        HelloSyncService helloSyncServiceReference = (HelloSyncService) applicationContext
                .getBean("helloSyncServiceReference");

        System.out.println(helloSyncServiceReference.saySync("sync"));


        GenericObject genericObject = new GenericObject(
                "com.alipay.sofa.rpc.samples.generic.SampleGenericParamModel");
        genericObject.putField("name", "Bible");


        GenericService sampleGenericServiceReference = (GenericService) applicationContext.getBean("helloGenericServiceReference");
        GenericObject genericResult = (GenericObject) sampleGenericServiceReference.$genericInvoke("sayGeneric",
                new String[]{"com.alipay.sofa.rpc.samples.generic.SampleGenericParamModel"},
                new Object[]{"xiao"});
    }

}
