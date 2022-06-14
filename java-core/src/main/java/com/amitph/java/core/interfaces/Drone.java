package com.amitph.java.core.interfaces;

public class Drone implements FlyingToy {

    @Override
    public void fly() {
        System.out.println("I am drone; I can fly");
    }

    @Override
    public void rest() {
        System.out.println("I am drone; I need rest too");
    }
}