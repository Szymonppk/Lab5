package org.example;
import java.util.List;

public class ShapeRender {
    public static void renderShapes(List<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println("Figura: " + shape.getClass().getSimpleName());
            System.out.println("Pole: " + shape.getArea());
            System.out.println("Obwód: " + shape.getPerimeter());
            System.out.println("Kolor: " + shape.getColorDescription());
            drawShape(shape);
            System.out.println("-----------------------------");
        }
    }

    private static void drawShape(Shape shape) {
        if (shape instanceof Rectangle rectangle) {
            drawRectangle(rectangle);
        } else if (shape instanceof Triangle triangle) {
            drawTriangle(triangle);
        } else {
            System.out.println("Nieznany typ figury.");
        }
    }

    private static void drawRectangle(Rectangle rectangle) {
        int width = (int) rectangle.getA();
        int height = (int) rectangle.getB();
        String color = rectangle.getColor().toAnsi();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(color+ "* " + "\u001B[0m");
            }
            System.out.println();
        }
    }

    private static void drawTriangle(Triangle triangle) {
        int height = (int) triangle.getH();
        String color = triangle.getColor().toAnsi();
        for (int i = 1; i <= height; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(color + "* " + "\u001B[0m");
            }
            System.out.println();
        }
    }

}
