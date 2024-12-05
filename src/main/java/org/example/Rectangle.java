package org.example;
import jakarta.persistence.*;

@Entity
@Table(name = "rectangle")
public class Rectangle extends Shape {

    @Column(nullable = false)
    private double a;

    @Column(nullable = false)
    private double b;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
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

    public Color getColor() {
        return color;
    }



    @Override
    public String getColorDescription() {
        return "R: " + this.color.getR() + " G: " + this.color.getG() + " B: " + this.color.getB() + " Alpha: " + this.color.getAlpha();
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

