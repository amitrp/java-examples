package com.amitph.java.core.interfaces;

public class Circle extends Shape implements Comparable<Circle> {
    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculateArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public int compareTo(Circle o) {
        return this.radius.compareTo(o.radius);
    }
}
