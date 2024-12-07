package org.example;
import jakarta.persistence.*;

@Entity
@Table(name = "color")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="red")
    private int r;
    @Column(name="green")
    private int g;
    @Column(name="blue")
    private int b;
    @Column(name="alpha")
    private double alpha;

    public Color() {
    }

    public Color(int r, int g, int b, double alpha) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.alpha = alpha;
    }

    public Color (int r, int g, int b) {
        this(r, g, b, 0);
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public String toAnsi() {
        return String.format("\u001B[38;2;%d;%d;%dm", r, g, b);
    }
}
