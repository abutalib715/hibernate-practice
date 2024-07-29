package com.talib.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Project Running...");

        Configuration configuration = new Configuration();
        configuration.configure();
//        configuration.configure("hibernate.cfg.xml"); // if file name or location customized
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // CREATE NEW STUDENT OBJ
        Student student = new Student();
        student.setName("Lablu");
        student.setCity("CTG");

        // GET CURRENT SESSION AND SAVE DATA
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            session.save(student);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        // Close the SessionFactory
        sessionFactory.close();
    }
}
