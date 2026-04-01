package com.maaza.myann.calc;

public final class BceCalculator implements Calculator {

    private static final float EPS = 1e-7f;

    @Override
    public final float loss(final float[] arr1, final float[] arr2) {
        final int len = arr1.length;
        float sum = 0.0f;
        for (int i = 0; i < len; i++) {
            final float val = Math.max(EPS, Math.min(1.0f - EPS, arr2[i]));
            sum += arr1[i] * (float) Math.log(val) + (1.0f - arr1[i]) * (float) Math.log(1.0f - val);
        }
        return -sum / len;
    }

    @Override
    public final void grad(final float[] arr1, final float[] arr2, final float[] arr3) {
        final int len = arr1.length;
        final float mul = 1.0f / len;
        for (int i = 0; i < len; i++) {
            final float val = Math.max(EPS, Math.min(1.0f - EPS, arr2[i]));
            arr3[i] = (val - arr1[i]) / (val * (1.0f - val)) * mul;
        }
    }
}
