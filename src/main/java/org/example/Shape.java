package org.example;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Rectangle.class, name = "rectangle"),
        @JsonSubTypes.Type(value = Triangle.class, name = "triangle")
})
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "shape_type", discriminatorType = DiscriminatorType.STRING, columnDefinition = "VARCHAR(255) DEFAULT 'unknown'")
public abstract class Shape {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;

    public Shape(){}

    public Shape(Color color)
    {
        this.color = color;
    }
    public Color getColor()
    {
        return color;
    }
    public void setColor(Color color)
    {
        this.color = color;
    }
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
    public String getColorDescription() {
        return "R: " + this.color.getR() + " G: " + this.color.getG() + " B: " + this.color.getB() + " Alpha: " + this.color.getAlpha();
    }
    public abstract double getArea();
    public abstract double getPerimeter();

}

