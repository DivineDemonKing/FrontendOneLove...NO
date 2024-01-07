package ru.kata.spring.boot_security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSecurityDemoApplication {
	//В тз не было ничего про страницу для регистрации нового пользователя поэтому я сделал проще
	//и просто создаю пользователей через тест CreateRolesAndUsers
	//Ну и соответственно при создании пользователя через форму /addUser у нового пользователя не будет никакой роли
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
	}

}
