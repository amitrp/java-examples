package com.amitph.java.core.abstraction;

public class FileLogger extends Logger{

    public FileLogger(String className) {
        super(className);
    }

    @Override
    public void print(String msg) {
        // write to file
    }
}