package com.talib.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // CREATE NEW STUDENT OBJ
        Student student = new Student();
        student.setName("Lablu");
        student.setCity("CTG");

        Certificate certificate = new Certificate();
        certificate.setCourse("Advance Java");
        certificate.setDuration("6 Months");
        student.setCertificate(certificate);

        session.save(student);

        System.out.println(student);

        Transaction tx = session.beginTransaction();
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
