package com.maaza.myann.init;

public final class Initializers {

    private Initializers() {
    }

    public static final Initializer fill(final float val) {
        return new FillInitializer(val);
    }

    public static final Initializer copy(final float[] arr) {
        return new CopyInitializer(arr);
    }

    public static final Initializer rndu(final float min, final float max) {
        return new RnduInitializer(min, max);
    }

    public static final Initializer rndu(final float min, final float max, final long sed) {
        return new RnduInitializer(min, max, sed);
    }

    public static final Initializer rndn(final float avg, final float sdv) {
        return new RndnInitializer(avg, sdv);
    }

    public static final Initializer rndn(final float avg, final float sdv, final long sed) {
        return new RndnInitializer(avg, sdv, sed);
    }

    public static final Initializer xavi(final int row, final int col) {
        final float val = (float) Math.sqrt(6.0f / (row + col));
        return new RnduInitializer(-val, val);
    }

    public static final Initializer xavi(final int row, final int col, final long sed) {
        final float val = (float) Math.sqrt(6.0f / (row + col));
        return new RnduInitializer(-val, val, sed);
    }

    public static final Initializer kaim(final int row) {
        final float val = (float) Math.sqrt(2.0f / row);
        return new RndnInitializer(0.0f, val);
    }

    public static final Initializer kaim(final int row, final long sed) {
        final float val = (float) Math.sqrt(2.0f / row);
        return new RndnInitializer(0.0f, val, sed);
    }
}
