package com.amitph.java.core.abstraction;

public class Square extends Shape {
    private final Double side;

    public Square(Double side, DrawingService drawingService) {
        super(drawingService);
        this.side = side;
    }

    @Override
    public Double calculateArea() {
        return side * side;
    }
}