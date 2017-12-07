package cn.three.core.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@ComponentScan(value = "cn.three.core.**")
public class Application {


	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}
