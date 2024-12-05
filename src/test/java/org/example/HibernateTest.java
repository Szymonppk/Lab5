package org.example;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class HibernateTest {
    private SessionFactory sessionFactory;
    private List<Rectangle> rectangles = new ArrayList<>();
    private Color color;

    @BeforeEach
    public void setUp() {
        sessionFactory = HibernateSetUp.getSession();
        color = new Color();
        color.setR(245);
        color.setG(115);
        color.setB(20);
        color.setAlpha(1);

        Rectangle rect1 = new Rectangle();
        rect1.setA(3);
        rect1.setB(4);
        rect1.setColor(color);

        Rectangle rect2 = new Rectangle();
        rect2.setA(5);
        rect2.setB(6);
        rect2.setColor(color);

        rectangles.add(rect1);
        rectangles.add(rect2);
    }

    @Test
    public void saveCheck() {
        ShapeDAO shapeDAO = new ShapeDAO();
        shapeDAO.save(color);
        shapeDAO.save(rectangles.get(0));

        Rectangle savedShape = (Rectangle) shapeDAO.getShape(rectangles.get(0).getId());

        assertNotNull(savedShape);
        assertEquals(rectangles.get(0).getA(), savedShape.getA());
        assertEquals(rectangles.get(0).getB(), savedShape.getB());
    }

    @Test
    public void readCheck() {
        ShapeDAO shapeDAO = new ShapeDAO();
        shapeDAO.save(color);
        shapeDAO.save(rectangles.get(0));

        Rectangle retrievedShape = (Rectangle) shapeDAO.getShape(rectangles.get(0).getId());

        assertNotNull(retrievedShape);
        assertEquals(rectangles.get(0).getA(), retrievedShape.getA());
        assertEquals(rectangles.get(0).getB(), retrievedShape.getB());
    }

    @Test
    public void updateCheck() {
        ShapeDAO shapeDAO = new ShapeDAO();
        shapeDAO.save(color);
        shapeDAO.save(rectangles.get(0));

        shapeDAO.updateShape(rectangles.get(0).getId(), rectangles.get(1));

        Rectangle updatedShape = (Rectangle) shapeDAO.getShape(rectangles.get(0).getId());

        assertEquals(rectangles.get(1).getA(), updatedShape.getA());
        assertEquals(rectangles.get(1).getB(), updatedShape.getB());
    }

    @Test
    public void deleteCheck() {
        ShapeDAO shapeDAO = new ShapeDAO();
        shapeDAO.save(color);
        shapeDAO.save(rectangles.get(0));

        shapeDAO.deleteShape(rectangles.get(0).getId());

        Rectangle deletedShape = (Rectangle) shapeDAO.getShape(rectangles.get(0).getId());
        assertNull(deletedShape);
    }
}
