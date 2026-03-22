package com.maaza.myann.init;

public final class CopyInitializer implements Initializer {

    private final float[] arr;

    public CopyInitializer(final float[] arr) {
        this.arr = arr;
    }

    @Override
    public final void init(final float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = this.arr[i];
        }
    }
}
