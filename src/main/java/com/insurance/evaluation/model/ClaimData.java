package com.insurance.evaluation.model;

import lombok.Data;

@Data
public class ClaimData {

    private String policyId;
    private String severity;
    private double initialPayout;

}