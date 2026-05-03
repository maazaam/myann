package com.maaza.myann.opti;

import java.util.IdentityHashMap;
import java.util.Map;

public final class MntmOptimizer implements Optimizer {

	private final float rate;
	private final float beta;
	private final float bm;
	private final Map<float[], float[]> vm;

	public MntmOptimizer(final float rate, final float beta) {
		this.rate = rate;
		this.beta = beta;
		this.bm = 1.0f - this.beta;
		this.vm = new IdentityHashMap<float[], float[]>();
	}

	@Override
	public final void next() {
	}

	@Override
	public final void step(final float[] arr1, final float[] arr2) {
		final int len = arr1.length;
		final float[] v = this.vm.computeIfAbsent(arr1, x -> new float[len]);
		for (int i = 0; i < len; i++) {
			v[i] = this.beta * v[i] + this.bm * arr2[i];
			arr1[i] -= this.rate * v[i];
		}
	}
}
