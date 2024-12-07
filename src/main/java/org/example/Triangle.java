package org.example;
import com.fasterxml.jackson.annotation.JsonTypeName;
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



    public Triangle() {

    }


    public Triangle(double a, double b, double c, double h, Color color) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;

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

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
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
