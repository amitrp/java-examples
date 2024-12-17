package com.amitph.java.core.interfaces;

public class FlyingToyFactory {
    private String env_flyingToyKey = "cow";

    public FlyingToy getFlyingToy() {
        if ("cow".equals(env_flyingToyKey)) {
            return new FlyingCow();
        }
        return new Drone();
    }
}
