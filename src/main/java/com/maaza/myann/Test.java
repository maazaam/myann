package com.maaza.myann;

import com.maaza.myann.acti.Activators;
import com.maaza.myann.calc.Calculators;
import com.maaza.myann.init.Initializers;
import com.maaza.myann.opti.Optimizers;
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
		final int row = 100;
		final int col = 100;
		final float val = 1.0f;
		final float min = 0.0f;
		final float max = 1.0f;
		final float avg = 0.0f;
		final float sdv = 1.0f;
		final float[] arr = { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f };

		final float val1 = (float) Math.sqrt(6.0f / (row + col));
		final float val2 = (float) Math.sqrt(2.0f / row);

		final float[] arr1 = new float[len];
		final float[] arr2 = new float[row * col];

		Initializers.fill(val).init(arr1);
		Utils.print("fill", arr1);

		Initializers.copy(arr).init(arr1);
		Utils.print("copy", arr1);

		Initializers.rndu(min, max).init(arr1);
		Utils.print("rndu", arr1);

		Initializers.rndn(avg, sdv).init(arr1);
		Utils.print("rndn", arr1);

		Utils.print("xavi");
		Initializers.xavi(row, col).init(arr2);
		Utils.print("val", val1);
		Utils.print("min", Utils.min(arr2));
		Utils.print("max", Utils.max(arr2));

		Utils.print("kaim");
		Initializers.kaim(row).init(arr2);
		Utils.print("val", val2);
		Utils.print("avg", Utils.avg(arr2));
		Utils.print("sdv", Utils.sdv(arr2));

	}

	private static final void acti() {

		Utils.print("acti");

		final int len = 9;
		final float min = -1.0f;
		final float max = +1.0f;

		final float[] arr = new float[len];
		final float[] arr1 = new float[len];
		final float[] arr2 = new float[len];

		Initializers.rndu(min, max).init(arr);

		Utils.print("arr", arr);

		for (int i = 0; i < len; i++) {
			arr1[i] = Activators.lelu().acti(arr[i]);
			arr2[i] = Activators.lelu().deri(arr[i]);
		}

		Utils.print("lelu-acti", arr1);
		Utils.print("lelu-deri", arr2);

		for (int i = 0; i < len; i++) {
			arr1[i] = Activators.relu().acti(arr[i]);
			arr2[i] = Activators.relu().deri(arr[i]);
		}

		Utils.print("relu-acti", arr1);
		Utils.print("relu-deri", arr2);

		for (int i = 0; i < len; i++) {
			arr1[i] = Activators.sigm().acti(arr[i]);
			arr2[i] = Activators.sigm().deri(arr[i]);
		}

		Utils.print("sigm-acti", arr1);
		Utils.print("sigm-deri", arr2);

		for (int i = 0; i < len; i++) {
			arr1[i] = Activators.tanh().acti(arr[i]);
			arr2[i] = Activators.tanh().deri(arr[i]);
		}

		Utils.print("tanh-acti", arr1);
		Utils.print("tanh-deri", arr2);

	}

	private static final void calc() {

		Utils.print("calc");

		final int len = 9;
		final float min = -1.0f;
		final float max = +1.0f;

		final float[] arr1 = new float[len];
		final float[] arr2 = new float[len];
		final float[] arr3 = new float[len];

		Initializers.rndu(min, max).init(arr1);
		Initializers.rndu(min, max).init(arr2);

		Utils.print("arr1", arr1);
		Utils.print("arr2", arr2);

		Utils.print("mse-loss", Calculators.mse().loss(arr1, arr2));
		Calculators.mse().grad(arr1, arr2, arr3);
		Utils.print("mse-grad", arr3);

		Utils.print("bce-loss", Calculators.bce().loss(arr1, arr2));
		Calculators.bce().grad(arr1, arr2, arr3);
		Utils.print("bce-grad", arr3);

	}

	private static final void opti() {

		Utils.print("opti");

		final int len = 9;
		final float min = -1.0f;
		final float max = +1.0f;
		final float rate0 = 0.01f;
		final float rate1 = 0.001f;
		final float beta0 = 0.9f;
		final float beta1 = 0.9f;
		final float beta2 = 0.999f;

		final float[] arr1 = new float[len];
		final float[] arr2 = new float[len];
		final float[] arr3 = new float[len];
		final float[] arr4 = new float[len];

		Initializers.rndu(min, max).init(arr1);
		Initializers.rndu(min, max).init(arr2);
		Initializers.rndu(min, max).init(arr3);
		Initializers.rndu(min, max).init(arr4);

		Utils.print("arr1", arr1);
		Utils.print("arr2", arr2);
		Utils.print("arr3", arr3);
		Utils.print("arr4", arr4);

		Optimizers.mntm(rate0, beta0).step(arr1, arr2);
		Utils.print("mntm", arr1);

		Optimizers.adam(rate1, beta1, beta2).step(arr3, arr4);
		Utils.print("adam", arr3);

	}

	public static final void main(final String[] args) {

		util();
		init();
		acti();
		calc();
		opti();

	}
}
