package com.insurance.evaluation.service;

import io.camunda.zeebe.client.ZeebeClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Service
@Slf4j
public class InsuranceClaimService implements CommandLineRunner {

    @Autowired
    private ZeebeClient zeebeClient;

    @Override
    public void run(final String... args) {
        var bpmnProcessId = "insurance-claim-evaluation";
        var event = zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId(bpmnProcessId)
                .latestVersion()
                .variables(Map.of("severity", "high"))
                .send()
                .join();
        log.info("started a process instance: {}", event.getProcessInstanceKey());
    }
}
