package org.robert.microservice.finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class MicroserviceRobertFinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceRobertFinanceApplication.class, args);
	}
}