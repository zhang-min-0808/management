package com.a.b.c;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.awt.*;
import java.io.IOException;

@SpringBootApplication
@ComponentScan("com.a.b.c")
@EnableAutoConfiguration
public class ServiceStarter {

    public static void main(String[] args) throws IOException {
        SpringApplication application=new SpringApplication(ServiceStarter.class);
        application.run(args);
        System.out.println("start success");
        //Desktop.getDesktop().browse(java.net.URI.create("http://localhost:8080/managment"));
    }
}
