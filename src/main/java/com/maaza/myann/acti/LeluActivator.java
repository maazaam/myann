package com.maaza.myann.acti;

public final class LeluActivator implements Activator {

	private static final float ALP = 0.01f;

	@Override
	public final float acti(final float val) {
		return Math.max(ALP * val, val);
	}

	@Override
	public final float deri(final float val) {
		return val > 0.0f ? 1.0f : ALP;
	}
}
