package com.maaza.myann;

import com.maaza.myann.acti.Activators;
import com.maaza.myann.calc.Calculators;
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
        final float[] arr = { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f };
        int row = 1;
        int col = 1;
        float val = 1.0f;
        float[] out = new float[len];
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
        Utils.print("xavi");
        row = 100;
        col = 100;
        val = (float) Math.sqrt(6.0f / (row + col));
        out = new float[row * col];
        Initializers.xavi(row, col).init(out);
        Utils.print("val", val);
        Utils.print("min", Utils.min(out));
        Utils.print("max", Utils.max(out));
        row = 3;
        col = 3;
        out = new float[row * col];
        Initializers.xavi(row, col, sed).init(out);
        Utils.print("xavi", out);
        Utils.print("kaim");
        row = 100;
        col = 100;
        val = (float) Math.sqrt(2.0f / row);
        out = new float[row * col];
        Initializers.kaim(row).init(out);
        Utils.print("val", val);
        Utils.print("avg", Utils.avg(out));
        Utils.print("sdv", Utils.sdv(out));
        row = 3;
        col = 3;
        out = new float[row * col];
        Initializers.kaim(row, sed).init(out);
        Utils.print("kaim", out);
    }

    private static final void acti() {
        Utils.print("acti");
        final float val = 1.0f;
        Utils.print("lelu-acti", Activators.lelu().acti(val));
        Utils.print("lelu-deri", Activators.lelu().deri(val));
        Utils.print("relu-acti", Activators.relu().acti(val));
        Utils.print("relu-deri", Activators.relu().deri(val));
        Utils.print("sigm-acti", Activators.sigm().acti(val));
        Utils.print("sigm-deri", Activators.sigm().deri(val));
        Utils.print("tanh-acti", Activators.tanh().acti(val));
        Utils.print("tanh-deri", Activators.tanh().deri(val));
    }

    private static final void calc() {
        Utils.print("calc");
        final int len = 4;
        final float[] arr1 = { 0.1f, 0.2f, 0.3f, 0.4f };
        final float[] arr2 = { 0.5f, 0.6f, 0.7f, 0.8f };
        final float[] arr3 = new float[len];
        Utils.print("mse-loss", Calculators.mse().loss(arr1, arr2));
        Calculators.mse().grad(arr1, arr2, arr3);
        Utils.print("mse-grad", arr3);
        Utils.print("bce-loss", Calculators.bce().loss(arr1, arr2));
        Calculators.bce().grad(arr1, arr2, arr3);
        Utils.print("bce-grad", arr3);
    }

    public static final void main(final String[] args) {
        util();
        init();
        acti();
        calc();
    }
}
