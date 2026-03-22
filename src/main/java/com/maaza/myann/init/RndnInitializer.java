package com.maaza.myann.init;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public final class RndnInitializer implements Initializer {

    private static final String ALG = "L64X128MixRandom";

    private final float avg;
    private final float sdv;
    private final RandomGenerator rng;

    public RndnInitializer(final float avg, final float sdv) {
        this.avg = avg;
        this.sdv = sdv;
        this.rng = RandomGeneratorFactory.of(ALG).create();
    }

    public RndnInitializer(final float avg, final float sdv, final long sed) {
        this.avg = avg;
        this.sdv = sdv;
        this.rng = RandomGeneratorFactory.of(ALG).create(sed);
    }

    @Override
    public final void init(final float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) this.rng.nextGaussian(this.avg, this.sdv);
        }
    }
}
