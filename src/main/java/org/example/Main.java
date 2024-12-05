package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ShapeDAO shapeDAO = new ShapeDAO();


        Color color = new Color();
        color.setR(100);
        color.setG(150);
        color.setB(200);
        color.setAlpha(1.0);


        Rectangle rectangle = new Rectangle();
        rectangle.setA(4.0);
        rectangle.setB(5.0);
        rectangle.setColor(color);


        Triangle triangle = new Triangle();
        triangle.setA(3.0);
        triangle.setB(4.0);
        triangle.setC(5.0);
        triangle.setH(8.0);
        triangle.setColor(color);


        shapeDAO.save(color);
        shapeDAO.save(rectangle);
        shapeDAO.save(triangle);


        Rectangle retrievedRectangle = (Rectangle) shapeDAO.getShape(rectangle.getId());
        System.out.println("Retrieved Rectangle:");
        System.out.println("A: " + retrievedRectangle.getA() + ", B: " + retrievedRectangle.getB());
        System.out.println("Color: " + retrievedRectangle.getColorDescription());


        retrievedRectangle.setA(10.0);
        retrievedRectangle.setB(20.0);
        shapeDAO.updateShape(retrievedRectangle.getId(), retrievedRectangle);


        Rectangle updatedRectangle = (Rectangle) shapeDAO.getShape(rectangle.getId());
        System.out.println("Updated Rectangle:");
        System.out.println("A: " + updatedRectangle.getA() + ", B: " + updatedRectangle.getB());
        System.out.println("Color: " + updatedRectangle.getColorDescription());


        shapeDAO.deleteShape(triangle.getId());
        Shape deletedTriangle = shapeDAO.getShape(triangle.getId());
    }
}