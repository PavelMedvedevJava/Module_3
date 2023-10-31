package org.example.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("org.example.cloud.dao.mapper")
@SpringBootApplication
public class JmpCloudServiceImplApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmpCloudServiceImplApplication.class, args);
	}
}