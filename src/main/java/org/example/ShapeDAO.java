package org.example;
import org.hibernate.*;
import java.util.List;

public class ShapeDAO {

    public void save(Shape shape) {
        Transaction transaction = null;
        try (Session session = HibernateSetUp.getSession().openSession()) {
            transaction = session.beginTransaction();
            session.save(shape);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public void save(Color color) {
        Transaction transaction = null;
        try (Session session = HibernateSetUp.getSession().openSession()) {
            transaction = session.beginTransaction();
            session.save(color);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public Shape getShape(Long id) {
        try (Session session = HibernateSetUp.getSession().openSession()) {
            return session.get(Shape.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void updateShape(Long id, Shape newShapeData) {
        Transaction transaction = null;
        try (Session session = HibernateSetUp.getSession().openSession()) {
            transaction = session.beginTransaction();
            Shape existingShape = session.get(newShapeData.getClass(), id);
            if (existingShape != null) {
                if (existingShape instanceof Rectangle && newShapeData instanceof Rectangle) {
                    Rectangle existingRectangle = (Rectangle) existingShape;
                    Rectangle newRectangleData = (Rectangle) newShapeData;

                    existingRectangle.setA(newRectangleData.getA());
                    existingRectangle.setB(newRectangleData.getB());
                    existingRectangle.setColor(newRectangleData.getColor());
                }
                session.update(existingShape);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Usunięcie obiektu z bazy danych na podstawie ID
    public void deleteShape(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateSetUp.getSession().openSession()) {
            transaction = session.beginTransaction();
            Shape shape = session.get(Shape.class, id);
            if (shape != null) {
                session.delete(shape);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }



}
