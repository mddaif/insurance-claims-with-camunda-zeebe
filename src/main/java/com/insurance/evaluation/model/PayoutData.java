package com.insurance.evaluation.model;

import lombok.Data;

@Data
public class PayoutData {
    private String claimId;
    private double initialPayout;
    private boolean fraudCheckPassed;
}
