package com.maaza.myann.opti;

public final class Optimizers {

    private Optimizers() {
    }

    public static final Optimizer mntm(final int size, final float rate, final float beta) {
        return new MntmOptimizer(size, rate, beta);
    }

    public static final Optimizer adam(final int size, final float rate, final float beta1, final float beta2) {
        return new AdamOptimizer(size, rate, beta1, beta2);
    }
}
