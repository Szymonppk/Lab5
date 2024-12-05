package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "triangle")
public class Triangle extends Shape {
    @Column(nullable = false)
    private double a;

    @Column(nullable = false)
    private double b;

    @Column(nullable = false)
    private double c;

    @Column(nullable = false)
    private double h;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void setH(double h) {
        this.h = h;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getH() {
        return h;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String getColorDescription() {
        return "R: " + this.color.getR() + " G: " + this.color.getG() + " B: " + this.color.getB() + " Alpha: " + this.color.getAlpha();
    }

    @Override
    public double getArea() {
        return a * h / 2;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }
}
