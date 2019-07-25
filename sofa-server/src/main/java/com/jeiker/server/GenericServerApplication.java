package com.jeiker.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * Description: sofa-boot-demo
 * User: jeikerxiao
 * Date: 2019/7/25 4:24 PM
 */
@ImportResource({"classpath*:rpc-server.xml"})
@SpringBootApplication
public class GenericServerApplication {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(GenericServerApplication.class);
        ApplicationContext applicationContext = springApplication.run(args);
    }
}