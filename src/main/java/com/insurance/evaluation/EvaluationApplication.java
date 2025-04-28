package com.insurance.evaluation;

import io.camunda.zeebe.spring.client.annotation.Deployment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Deployment(resources = "classpath:insurance_claim.bpmn")
public class EvaluationApplication {

	public static void main(String[] args) {

		SpringApplication.run(EvaluationApplication.class, args);
	}

}
