package com.amitph.java.core.abstraction;

public class ConsoleLogger extends Logger {
    public ConsoleLogger(String className) {
        super(className);
    }

    @Override
    public void print(String msg) {
        // Write To Console
    }
}