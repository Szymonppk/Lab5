package org.example;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "shape")
public abstract class Shape {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shape_id;
    public Long getId() {
        return shape_id;
    }
    public abstract String getColorDescription();
    public abstract double getArea();
    public abstract double getPerimeter();

}

