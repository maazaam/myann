package com.maaza.myann.util;

public final class Utils {

    private Utils() {
    }

    public static final float min(final float[] arr) {
        float min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    public static final float max(final float[] arr) {
        float max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static final float avg(final float[] arr) {
        float sum = 0.0f;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }

    public static final float sdv(final float[] arr) {
        float sum = 0.0f;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        final float avg = sum / arr.length;
        float dev = 0.0f;
        for (int i = 0; i < arr.length; i++) {
            dev += Math.pow(arr[i] - avg, 2.0f);
        }
        final float var = dev / arr.length;
        return (float) Math.sqrt(var);
    }

    public static final void print(final String str) {
        System.out.printf("%n----- %s -----%n", str);
    }

    public static final void print(final String str, final float val) {
        System.out.printf("%s = %+.3f%n", str, val);
    }

    public static final void print(final String str, final float[] arr) {
        System.out.printf("%s[%d] = { ", str, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%+.3f ", arr[i]);
        }
        System.out.printf("}%n");
    }

    public static final void benchmark(final Runnable task, final String name, final int warmup, final int measure) {

        System.out.printf("%n========== Benchmark: %s ==========%n", name);
        System.out.printf("Warmup: %d, Measure: %d%n%n", warmup, measure);

        for (int i = 0; i < warmup; i++) {
            task.run();
        }

        final Runtime runtime = Runtime.getRuntime();

        long totalTime = 0;
        long totalMemory = 0;

        for (int i = 0; i < measure; i++) {

            System.gc();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            final long before = runtime.totalMemory() - runtime.freeMemory();
            final long start = System.nanoTime();

            task.run();

            final long stop = System.nanoTime();
            final long after = runtime.totalMemory() - runtime.freeMemory();

            final long time = stop - start;
            final long memory = after - before;

            System.out.printf("Run %2d | Time: %.3f ms | Memory: %.2f kb%n", i + 1, time / 1_000_000.0, memory / 1_024.0);

            totalTime += time;
            totalMemory += memory;

        }

        final double averageTime = totalTime / (measure * 1_000_000.0);
        final double averageMemory = totalMemory / (measure * 1_024.0);

        System.out.printf("%nAverage Time   : %.3f ms", averageTime);
        System.out.printf("%nAverage Memory : %.2f kb%n", averageMemory);

    }
}
