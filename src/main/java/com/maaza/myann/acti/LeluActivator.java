package com.maaza.myann.acti;

public final class LeluActivator implements Activator {

    private final float val;

    public LeluActivator() {
        this.val = 0.01f;
    }

    @Override
    public final float acti(final float val) {
        return val > 0.0f ? val : this.val * val;
    }

    @Override
    public final float deri(final float val) {
        return val > 0.0f ? 1.0f : this.val;
    }
}
