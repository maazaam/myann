package com.maaza.myann.opti;

public final class Optimizers {

	private Optimizers() {
	}

	public static final Optimizer mntm(final float rate, final float beta) {
		return new MntmOptimizer(rate, beta);
	}

	public static final Optimizer adam(final float rate, final float beta1, final float beta2) {
		return new AdamOptimizer(rate, beta1, beta2);
	}
}
