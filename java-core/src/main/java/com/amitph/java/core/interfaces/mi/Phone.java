package com.amitph.java.core.interfaces.mi;

public interface Phone {
    default void start() {
        System.out.println("Phone is starting");
    }
}
