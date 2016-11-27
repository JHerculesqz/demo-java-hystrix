package com.huawei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class HystrixClientApplication {
	// #region main

	public static void main(String[] args) {
		SpringApplication.run(HystrixClientApplication.class, args);
	}

	// #endregion
}
