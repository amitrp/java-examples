package com.amitph.java.core.abstraction;

public abstract class Logger {
    private String logPattern = "%s | %s | %s";
    private final String className;

    public Logger(String className) {
        this.className = className;
    }

    public void setLogPattern(String logPattern) {
        this.logPattern = logPattern;
    }

    public abstract void print(String msg);

    public String getLogPattern() {
        return logPattern;
    }

    public String getClassName() {
        return className;
    }
}
