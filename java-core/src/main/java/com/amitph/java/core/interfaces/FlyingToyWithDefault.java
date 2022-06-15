package com.amitph.java.core.interfaces;

public interface FlyingToyWithDefault {
    void fly();

    default void rest() {
        System.out.println("If not told explicitly, " +
                "I rest like this");
    }
}