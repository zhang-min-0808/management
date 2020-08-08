package com.a.b.c;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ServiceStarter {

    public static void main(String[] args){
        SpringApplication application=new SpringApplication(ServiceStarter.class);
        application.run(args);
        System.out.println("start success");
    }
}
