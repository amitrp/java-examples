package com.amitph.java.core.interfaces;

public class FlyingCow implements FlyingToy {
    @Override
    public void fly() {
        System.out.println("I am cow; I can fly");
    }

    @Override
    public void rest() {
        System.out.println("I am cow; I need rest too");
    }
}