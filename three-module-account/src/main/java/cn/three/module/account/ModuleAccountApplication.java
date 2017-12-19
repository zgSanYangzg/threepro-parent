package cn.three.module.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@ComponentScan(value = "cn.three.**")
public class ModuleAccountApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ModuleAccountApplication.class, args);
    }
}
