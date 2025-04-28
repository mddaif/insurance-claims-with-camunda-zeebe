package com.insurance.evaluation.worker;

import com.insurance.evaluation.model.ClaimData;
import com.insurance.evaluation.model.PayoutData;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import io.camunda.zeebe.spring.client.annotation.Variable;
import io.camunda.zeebe.spring.client.annotation.VariablesAsType;
import java.util.Map;
import java.util.Random;

@Component
@Slf4j
public class InsuranceClaimWorker {

    private static final Random RANDOM = new Random();

    @JobWorker(type = "fraud-check")
    public Map<String, Boolean> performFraudCheck(@VariablesAsType ClaimData claimData) {

        log.info("initial payout : {}", claimData.getInitialPayout());
        boolean passed = simulateFraudDetection(claimData);
        return Map.of("fraudCheckPassed", passed);
    }


    @JobWorker(type = "authorize-payout")
    public Map<String, Boolean> performAuthorizePayout(@VariablesAsType PayoutData payoutData) {

        log.info("authorize payout : {}", payoutData.getInitialPayout());
        if (!payoutData.isFraudCheckPassed()) {
            throw new RuntimeException("Cannot authorize payout: fraud check failed!");
        }
        return Map.of("authorizePayout", true);

    }

    boolean simulateFraudDetection(ClaimData claimData) {

        if(claimData.getInitialPayout() > 10000) {
            boolean result = RANDOM.nextBoolean();
            log.info("fraud detection result for high amount : {}", result);
            return result;
        } else {
            log.info("claim amount low --- automatically passing fraud check");
            return true;
        }
    }

}
