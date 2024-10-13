package com.co.clientcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.co.clientcontrol.*"})
public class MsClientControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsClientControlApplication.class, args);
	}

}
