package com.maaza.myann;

import com.maaza.myann.acti.Activator;
import com.maaza.myann.acti.Activators;
import com.maaza.myann.calc.Calculator;
import com.maaza.myann.calc.Calculators;
import com.maaza.myann.init.Initializer;
import com.maaza.myann.init.Initializers;
import com.maaza.myann.opti.Optimizer;
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

		Initializer fill = Initializers.fill(val);
		fill.init(arr1);
		Utils.print("fill", arr1);

		Initializer copy = Initializers.copy(arr);
		copy.init(arr1);
		Utils.print("copy", arr1);

		Initializer rndu = Initializers.rndu(min, max);
		rndu.init(arr1);
		Utils.print("rndu", arr1);

		Initializer rndn = Initializers.rndn(avg, sdv);
		rndn.init(arr1);
		Utils.print("rndn", arr1);

		Utils.print("xavi");
		Initializer xavi = Initializers.xavi(row, col);
		xavi.init(arr2);
		Utils.print("val", val1);
		Utils.print("min", Utils.min(arr2));
		Utils.print("max", Utils.max(arr2));

		Utils.print("kaim");
		Initializer kaim = Initializers.kaim(row);
		kaim.init(arr2);
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

		Initializer rndu = Initializers.rndu(min, max);
		rndu.init(arr);

		Utils.print("arr", arr);

		Activator lelu = Activators.lelu();
		for (int i = 0; i < len; i++) {
			arr1[i] = lelu.acti(arr[i]);
			arr2[i] = lelu.deri(arr[i]);
		}

		Utils.print("lelu-acti", arr1);
		Utils.print("lelu-deri", arr2);

		Activator relu = Activators.relu();
		for (int i = 0; i < len; i++) {
			arr1[i] = relu.acti(arr[i]);
			arr2[i] = relu.deri(arr[i]);
		}

		Utils.print("relu-acti", arr1);
		Utils.print("relu-deri", arr2);

		Activator sigm = Activators.sigm();
		for (int i = 0; i < len; i++) {
			arr1[i] = sigm.acti(arr[i]);
			arr2[i] = sigm.deri(arr[i]);
		}

		Utils.print("sigm-acti", arr1);
		Utils.print("sigm-deri", arr2);

		Activator tanh = Activators.tanh();
		for (int i = 0; i < len; i++) {
			arr1[i] = tanh.acti(arr[i]);
			arr2[i] = tanh.deri(arr[i]);
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

		Initializer rndu = Initializers.rndu(min, max);
		rndu.init(arr1);
		rndu.init(arr2);

		Utils.print("arr1", arr1);
		Utils.print("arr2", arr2);

		Calculator mse = Calculators.mse();
		Utils.print("mse-loss", mse.loss(arr1, arr2));
		mse.grad(arr1, arr2, arr3);
		Utils.print("mse-grad", arr3);

		Calculator bce = Calculators.bce();
		Utils.print("bce-loss", bce.loss(arr1, arr2));
		bce.grad(arr1, arr2, arr3);
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

		Initializer rndu = Initializers.rndu(min, max);
		rndu.init(arr1);
		rndu.init(arr2);
		rndu.init(arr3);
		rndu.init(arr4);

		Utils.print("arr1", arr1);
		Utils.print("arr2", arr2);
		Utils.print("arr3", arr3);
		Utils.print("arr4", arr4);

		Optimizer mntm = Optimizers.mntm(rate0, beta0);
		mntm.next();
		mntm.step(arr1, arr2);
		Utils.print("mntm", arr1);

		Optimizer adam = Optimizers.adam(rate1, beta1, beta2);
		adam.next();
		adam.step(arr3, arr4);
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
