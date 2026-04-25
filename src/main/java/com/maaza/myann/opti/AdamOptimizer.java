package com.maaza.myann.opti;

public final class AdamOptimizer implements Optimizer {

    private static final float EPS = 1.0e-8f;

    private final int size;
    private final float rate;
    private final float beta1;
    private final float beta2;
    private final float[] m;
    private final float[] v;
    private final float b1m;
    private final float b2m;
    private float b1t;
    private float b2t;

    public AdamOptimizer(final int size, final float rate, final float beta1, final float beta2) {
        this.size = size;
        this.rate = rate;
        this.beta1 = beta1;
        this.beta2 = beta2;
        this.m = new float[this.size];
        this.v = new float[this.size];
        this.b1m = 1.0f - this.beta1;
        this.b2m = 1.0f - this.beta2;
        this.b1t = 1.0f;
        this.b2t = 1.0f;
    }

    @Override
    public final void step(final float[] arr1, final float[] arr2) {
        this.b1t *= this.beta1;
        this.b2t *= this.beta2;
        final float b1c = 1.0f - this.b1t;
        final float b2c = 1.0f - this.b2t;
        for (int i = 0; i < this.size; i++) {
            this.m[i] = this.beta1 * this.m[i] + this.b1m * arr2[i];
            this.v[i] = this.beta2 * this.v[i] + this.b2m * arr2[i] * arr2[i];
            final float mh = this.m[i] / b1c;
            final float vh = this.v[i] / b2c;
            arr1[i] -= this.rate * mh / ((float) Math.sqrt(vh) + EPS);
        }
    }
}
