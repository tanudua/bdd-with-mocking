package com.bdd.with.mocking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author tanudua created on 10/4/2021
 */
@SpringBootApplication/*(exclude = ConfigReloadAutoConfiguration.class)*/
@EnableAutoConfiguration
@EnableSwagger2
@ComponentScan({"com.bdd.with.mocking.*"})
public class BddWithMockingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BddWithMockingApplication.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "swagger-ui.html";
    }
}
