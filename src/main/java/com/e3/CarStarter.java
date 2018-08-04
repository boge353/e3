package com.e3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.e3.cart.mapper")
public class CarStarter {
	public static void main(String[] args) {
		SpringApplication.run(CarStarter.class, args);
	}

}
