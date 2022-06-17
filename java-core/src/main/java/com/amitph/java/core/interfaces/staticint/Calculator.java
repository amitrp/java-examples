package com.amitph.java.core.interfaces.staticint;

public interface Calculator {
    static int add(int x, int y) {
        logMessage("calculating (" + x + "+" + y + ")");
        return x + y;
    }

    static int subtract(int x, int y) {
        logMessage("calculating (" + x + "-" + y + ")");
        return x - y;
    }

    private static void logMessage(String msg) {
        //Log it
    }

    static void main(String[] a) {
        System.out.println("Main. Executing from an interface");
    }
}