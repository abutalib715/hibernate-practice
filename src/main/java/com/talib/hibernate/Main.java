package com.talib.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

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
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        session.save(student);
        tx.commit();
        sessionFactory.close();
    }
}
