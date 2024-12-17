package com.amitph.java.core.interfaces.mi;

public interface Device {
    default void start() {
        System.out.println("Device is starting");
    }
}
