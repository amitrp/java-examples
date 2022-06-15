package com.amitph.java.core.interfaces.mi;

public interface SmartDevice extends Device {
    @Override
    default void start() {
        System.out.println("Smart Device is starting");
    }
}
