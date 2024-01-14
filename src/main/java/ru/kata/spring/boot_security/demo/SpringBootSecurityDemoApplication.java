package ru.kata.spring.boot_security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSecurityDemoApplication {
	/*
	День потратил на эти 3(4) строчки кода.
	<div class="gap-2 col-2">
    	<a type="button" class="btn btn-primary text-light w-100">Admin</a>
        <a type="button" class="btn btn-link w-100" th:href ="@{/user}">User</a>
    </div>
	Пришлось даже подключать 5тый bootstrap.
    Просто для понимания в какую ж я себя загнал, изначально я сделал вот так
    <div class="btn-group-vertical col-2" style="height: 10vh;">
        <a type="button" class="btn btn-primary text-light">Admin</a>
        <a type="button" class="btn btn-link" th:href ="@{/user}">User</a>
    </div>
    И когда мне надо было убрать Admin кнопку для обычного user'а начались свистопляски
    с попытками сделать style="height: 5vh" для отдельной кнопки. Весело короче :)
    P.S Там вроде надо было сделать это с каким-то минимальным использованием css но я сделал без
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
	}

}
