package com.maaza.myann.init;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public final class RnduInitializer implements Initializer {

    private static final String ALG = "L64X128MixRandom";

    private final float min;
    private final float max;
    private final RandomGenerator rng;

    public RnduInitializer(final float min, final float max) {
        this.min = min;
        this.max = max;
        this.rng = RandomGeneratorFactory.of(ALG).create();
    }

    public RnduInitializer(final float min, final float max, final long sed) {
        this.min = min;
        this.max = max;
        this.rng = RandomGeneratorFactory.of(ALG).create(sed);
    }

    @Override
    public final void init(final float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) this.rng.nextDouble(this.min, this.max);
        }
    }
}
