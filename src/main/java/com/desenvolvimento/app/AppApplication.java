package com.desenvolvimento.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*Component scan define o pacote inicial para busca dos componentes da aplicação*/
@ComponentScan(basePackages = "com.desenvolvimento") //ta dando erro quando invoco tudo do pacote

/*Entity Scan scaneia os pacotes onde as entidades estão*/
@EntityScan(basePackages = {"com.desenvolvimento.domains", "com.desenvolvimento.domains.enums"})

/*define o pacote dos repositories*/
@EnableJpaRepositories(basePackages = "com.desenvolvimento.repositories")

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
