package org.example;
import jakarta.persistence.*;


@Entity
@Table(name = "rectangle")
public class Rectangle extends Shape {

    @Column(nullable = false)
    private double a;

    @Column(nullable = false)
    private double b;

    public Rectangle() {

    }

    public Rectangle(double a, double b, Color color) {
        super(color);
        this.a = a;
        this.b = b;

    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public double getArea() {
        return a * b;
    }

    @Override
    public double getPerimeter() {
        return 2 * a + 2 * b;
    }
}
