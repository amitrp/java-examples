package com.amitph.java.core.interfaces.privateint;

public interface Calculator {
    default int add(int x, int y) {
        logMessage("calculating (" + x + "+" + y + ")");
        return x + y;
    }

    default int subtract(int x, int y) {
        logMessage("calculating (" + x + "-" + y + ")");
        return x - y;
    }

    private void logMessage(String msg) {
        // Log it
    }
}
