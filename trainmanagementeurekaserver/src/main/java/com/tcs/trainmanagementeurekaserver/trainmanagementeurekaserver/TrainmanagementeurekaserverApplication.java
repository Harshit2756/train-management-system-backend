package com.tcs.trainmanagementeurekaserver.trainmanagementeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TrainmanagementeurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainmanagementeurekaserverApplication.class, args);
	}

}
