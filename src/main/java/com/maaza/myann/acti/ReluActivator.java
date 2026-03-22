package com.maaza.myann.acti;

public final class ReluActivator implements Activator {

    @Override
    public final float acti(final float val) {
        return val > 0.0f ? val : 0.0f;
    }

    @Override
    public final float deri(final float val) {
        return val > 0.0f ? 1.0f : 0.0f;
    }
}
