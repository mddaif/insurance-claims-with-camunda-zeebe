package com.insurance.evaluation.service;

import io.camunda.zeebe.client.ZeebeClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Service
@Slf4j
public class InsuranceClaimService {

    @Autowired
    private ZeebeClient zeebeClient;


}
