package com.maaza.myann.init;

public final class CopyInitializer implements Initializer {

    private final float[] arr;

    public CopyInitializer(final float[] arr) {
        this.arr = arr;
    }

    @Override
    public final void init(final float[] arr) {
        final int len = arr.length;
        for (int i = 0; i < len; i++) {
            arr[i] = this.arr[i];
        }
    }
}
