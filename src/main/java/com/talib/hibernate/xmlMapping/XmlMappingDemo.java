package com.talib.hibernate.xmlMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class XmlMappingDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Person person = new Person(12, "Didar", "Dhaka");
        session.persist(person);

        Transaction tx = session.beginTransaction();
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
