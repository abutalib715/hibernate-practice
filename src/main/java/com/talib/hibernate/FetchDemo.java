package com.talib.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Student student = (Student) session.get(Student.class, 203);
//        Student student = (Student) session.load(Student.class, 203);
        System.out.println(student);

        session.close();
        sessionFactory.close();
    }
}
