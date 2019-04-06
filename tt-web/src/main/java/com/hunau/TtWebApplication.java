package com.hunau;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hunau.mapper")
@SpringBootApplication
public class TtWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TtWebApplication.class, args);
	}

}
