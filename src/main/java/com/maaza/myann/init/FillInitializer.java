package com.maaza.myann.init;

public final class FillInitializer implements Initializer {

    private final float val;

    public FillInitializer(final float val) {
        this.val = val;
    }

    @Override
    public final void init(final float[] arr) {
        final int len = arr.length;
        for (int i = 0; i < len; i++) {
            arr[i] = this.val;
        }
    }
}
