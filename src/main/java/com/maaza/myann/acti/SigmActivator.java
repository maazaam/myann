package com.maaza.myann.acti;

public final class SigmActivator implements Activator {

    @Override
    public final float acti(final float val) {
        if (val >= 0.0f) {
            final float exp = (float) Math.exp(-val);
            return 1.0f / (1.0f + exp);
        } else {
            final float exp = (float) Math.exp(val);
            return exp / (1.0f + exp);
        }
    }

    @Override
    public final float deri(final float val) {
        return val * (1.0f - val);
    }
}
