package org.example;
import jakarta.persistence.*;

@Entity
@Table(name="color")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long color_id;
    @Column(nullable = false)
    private int r;
    @Column(nullable = false)
    private int g;
    @Column(nullable = false)
    private int b;
    @Column(nullable = false)
    private double alpha;

    public void setR(int r) {
        this.r = r;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public double getAlpha() {
        return alpha;
    }

    public String toAnsi() {
        return String.format("\u001B[38;2;%d;%d;%dm", r, g, b);
    }
}
