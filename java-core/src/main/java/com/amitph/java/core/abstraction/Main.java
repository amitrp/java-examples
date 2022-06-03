package com.amitph.java.core.abstraction;

public class Main {
    public static void main(String[] arg) {
        Shape shape = new Circle(14.5, new DrawingService());
        System.out.println("Circle area: " + shape.calculateArea());

        shape = new Square(10.1, new DrawingService());
        System.out.println("Square area: " + shape.calculateArea());
    }
}