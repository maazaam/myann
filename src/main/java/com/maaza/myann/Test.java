package com.maaza.myann;

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

    public static final void main(final String[] args) {
        util();
    }
}
