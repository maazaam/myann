package com.maaza.myann;

import com.maaza.myann.init.Initializers;
import com.maaza.myann.util.Utils;

public final class Test {

    private Test() {
    }

    private static final void util() {
        Utils.print("util");
        final float[] arr = { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f };
        Utils.print("arr", arr);
        Utils.print("min", Utils.min(arr));
        Utils.print("max", Utils.max(arr));
        Utils.print("avg", Utils.avg(arr));
        Utils.print("sdv", Utils.sdv(arr));
        Utils.benchmark(() -> Utils.sdv(arr), "sdv", 10, 5);
    }

    private static final void init() {
        Utils.print("init");
        final int len = 9;
        final long sed = 42l;
        final float min = 0.0f;
        final float max = 1.0f;
        final float avg = 0.0f;
        final float sdv = 1.0f;
        final float val = 1.0f;
        final float[] arr = { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f };
        final float[] out = new float[len];
        Initializers.fill(val).init(out);
        Utils.print("fill", out);
        Initializers.copy(arr).init(out);
        Utils.print("copy", out);
        Initializers.rndu(min, max).init(out);
        Utils.print("rndu", out);
        Initializers.rndu(min, max, sed).init(out);
        Utils.print("rndu", out);
        Initializers.rndn(avg, sdv).init(out);
        Utils.print("rndn", out);
        Initializers.rndn(avg, sdv, sed).init(out);
        Utils.print("rndn", out);
    }

    public static final void main(final String[] args) {
        util();
        init();
    }
}
