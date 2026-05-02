package com.maaza.myann.calc;

public final class MseCalculator implements Calculator {

	@Override
	public final float loss(final float[] arr1, final float[] arr2) {
		final int len = arr1.length;
		float sum = 0.0f;
		for (int i = 0; i < len; i++) {
			final float dif = arr1[i] - arr2[i];
			sum += dif * dif;
		}
		return sum / len;
	}

	@Override
	public final void grad(final float[] arr1, final float[] arr2, final float[] arr3) {
		final int len = arr1.length;
		final float mul = 2.0f / len;
		for (int i = 0; i < len; i++) {
			arr3[i] = (arr2[i] - arr1[i]) * mul;
		}
	}
}
