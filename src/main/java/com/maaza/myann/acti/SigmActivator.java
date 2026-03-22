package com.maaza.myann.acti;

public final class SigmActivator implements Activator {

    @Override
    public final float acti(final float val) {
        return 1.0f / (1.0f + (float) Math.exp(-val));
    }

    @Override
    public final float deri(final float val) {
        return val * (1.0f - val);
    }
}
