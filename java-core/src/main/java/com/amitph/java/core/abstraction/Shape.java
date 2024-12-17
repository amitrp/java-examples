package com.amitph.java.core.abstraction;

public abstract class Shape {
    private final DrawingService drawingService;

    public Shape(DrawingService drawingService) {
        this.drawingService = drawingService;
    }

    public abstract Double calculateArea();

    public void draw() {
        drawingService.draw(this);
    }
}
