package cn.three.core.database;

import cn.three.core.database.dao.BaseRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@ComponentScan(value = "cn.three.**")
@EnableJpaRepositories(basePackages = {"cn.three.core.database.dao"},
		repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class Application {


	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}
