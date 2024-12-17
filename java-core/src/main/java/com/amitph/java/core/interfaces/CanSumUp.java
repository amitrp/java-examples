package com.amitph.java.core.interfaces;

public interface CanSumUp {
    default Integer addInts(Integer x, Integer y) {
        logAddNumbers(x, y);
        return x + y;
    }

    default Double addDoubles(Double x, Double y) {
        logAddNumbers(x, y);
        return x + y;
    }

    private void logAddNumbers(Number x, Number y) {
        System.out.println("Adding: " + x + ", " + y);
    }
}
