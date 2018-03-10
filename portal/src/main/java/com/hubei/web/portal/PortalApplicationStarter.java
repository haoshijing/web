package com.hubei.web.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@ImportResource({"classpath:application-context.xml"})
@EnableScheduling
@SpringBootApplication
public class PortalApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(PortalApplicationStarter.class, args);
    }
}
