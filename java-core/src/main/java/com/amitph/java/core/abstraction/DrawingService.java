package com.amitph.java.core.abstraction;

public class DrawingService {
    public void draw(Shape shape) {
        System.out.println("Drawing the area + " + shape.calculateArea());
    }
}
