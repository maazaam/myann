package com.maaza.myann.calc;

public final class Calculators {

    private static final Calculator MSE = new MseCalculator();
    private static final Calculator BCE = new BceCalculator();

    private Calculators() {
    }

    public static final Calculator mse() {
        return MSE;
    }

    public static final Calculator bce() {
        return BCE;
    }
}
