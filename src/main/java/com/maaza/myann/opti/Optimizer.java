package com.maaza.myann.opti;

public interface Optimizer {

	public void next();

	public void step(float[] arr1, float[] arr2);
}
