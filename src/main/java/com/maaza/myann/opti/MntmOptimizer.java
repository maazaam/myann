package com.maaza.myann.opti;

public final class MntmOptimizer implements Optimizer {

    private final int size;
    private final float rate;
    private final float beta;
    private final float[] v;

    public MntmOptimizer(final int size, final float rate, final float beta) {
        this.size = size;
        this.rate = rate;
        this.beta = beta;
        this.v = new float[this.size];
    }

    @Override
    public final void step(final float[] arr1, final float[] arr2) {
        for (int i = 0; i < this.size; i++) {
            this.v[i] = this.beta * this.v[i] + arr2[i];
            arr1[i] -= this.rate * this.v[i];
        }
    }
}
