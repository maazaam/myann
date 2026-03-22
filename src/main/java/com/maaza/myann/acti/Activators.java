package com.maaza.myann.acti;

public final class Activators {

    private Activators() {
    }

    public static final Activator lelu() {
        return new LeluActivator();
    }

    public static final Activator relu() {
        return new ReluActivator();
    }

    public static final Activator sigm() {
        return new SigmActivator();
    }

    public static final Activator tanh() {
        return new TanhActivator();
    }
}
