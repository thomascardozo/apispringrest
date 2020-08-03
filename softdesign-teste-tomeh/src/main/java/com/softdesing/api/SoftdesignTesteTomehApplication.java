package com.softdesing.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Configuração essencial para uma aplicação completa com Springboot
@SpringBootApplication
@EntityScan(basePackages = { "com.softdesing.api.model" }) // varre as pastas de model
@ComponentScan(basePackages = { "com.*" }) // varre tudo que estiver na pasta com
@EnableMongoRepositories(basePackages = { "com.softdesing.api.repository" }) // interfaces de persistência
//@EnableTransactionManagement // controle de transações
@EnableWebMvc // caso tenha necessidade de usar esta arquitetura
@RestController
@EnableAutoConfiguration
@EnableCaching
public class SoftdesignTesteTomehApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SoftdesignTesteTomehApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}

	/*Mapeamento global que reflete em todo o sistema*/
	@Override
	public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {

		registry.addMapping("/usuario/**")
		.allowedMethods("*")// libera requisições DELETE apenas para determinado controller (todos métodos UserController, por exemplo)
				.allowedOrigins("*"); /* utilizando .allowedOrigins("www.devlabstg.com") pode-se definir apenas este servidor
				 p/ realizar alterações */
	}
	
	

}
