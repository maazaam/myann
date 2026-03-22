package com.maaza.myann.acti;

public final class TanhActivator implements Activator {

    @Override
    public final float acti(final float val) {
        return (float) Math.tanh(val);
    }

    @Override
    public final float deri(final float val) {
        return 1.0f - (float) Math.pow(val, 2.0f);
    }
}
