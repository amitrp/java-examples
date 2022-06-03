package com.amitph.java.core.abstraction;

public class Circle extends Shape {
    private final Double radius;

    public Circle(Double radius, DrawingService drawingService) {
        super(drawingService);
        this.radius = radius;
    }

    @Override
    public Double calculateArea() {
        return radius * radius * Math.PI;
    }
}