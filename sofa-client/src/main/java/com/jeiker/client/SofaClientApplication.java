package com.jeiker.client;

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
    }

}
