package com.maaza.myann.acti;

public final class Activators {

	private static final Activator LELU = new LeluActivator();
	private static final Activator RELU = new ReluActivator();
	private static final Activator SIGM = new SigmActivator();
	private static final Activator TANH = new TanhActivator();

	private Activators() {
	}

	public static final Activator lelu() {
		return LELU;
	}

	public static final Activator relu() {
		return RELU;
	}

	public static final Activator sigm() {
		return SIGM;
	}

	public static final Activator tanh() {
		return TANH;
	}
}
