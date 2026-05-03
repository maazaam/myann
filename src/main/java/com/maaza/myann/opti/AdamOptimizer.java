package com.maaza.myann.opti;

import java.util.IdentityHashMap;
import java.util.Map;

public final class AdamOptimizer implements Optimizer {

	private static final float EPS = 1.0e-8f;

	private final float rate;
	private final float beta1;
	private final float beta2;
	private final float b1m;
	private final float b2m;
	private final Map<float[], float[]> mm;
	private final Map<float[], float[]> vm;
	private float b1t;
	private float b2t;

	public AdamOptimizer(final float rate, final float beta1, final float beta2) {
		this.rate = rate;
		this.beta1 = beta1;
		this.beta2 = beta2;
		this.b1m = 1.0f - this.beta1;
		this.b2m = 1.0f - this.beta2;
		this.mm = new IdentityHashMap<float[], float[]>();
		this.vm = new IdentityHashMap<float[], float[]>();
		this.b1t = 1.0f;
		this.b2t = 1.0f;
	}

	@Override
	public final void next() {
		this.b1t *= this.beta1;
		this.b2t *= this.beta2;
	}

	@Override
	public final void step(final float[] arr1, final float[] arr2) {
		final int len = arr1.length;
		final float[] m = this.mm.computeIfAbsent(arr1, x -> new float[len]);
		final float[] v = this.vm.computeIfAbsent(arr1, x -> new float[len]);
		final float b1c = 1.0f / (1.0f - this.b1t);
		final float b2c = 1.0f / (1.0f - this.b2t);
		for (int i = 0; i < len; i++) {
			m[i] = this.beta1 * m[i] + this.b1m * arr2[i];
			v[i] = this.beta2 * v[i] + this.b2m * arr2[i] * arr2[i];
			final float mh = m[i] * b1c;
			final float vh = v[i] * b2c;
			arr1[i] -= this.rate * mh / ((float) Math.sqrt(vh) + EPS);
		}
	}
}
