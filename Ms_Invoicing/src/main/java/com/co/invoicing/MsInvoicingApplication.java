package com.co.invoicing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.co.invoicing.*"})
public class MsInvoicingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsInvoicingApplication.class, args);
	}

}
