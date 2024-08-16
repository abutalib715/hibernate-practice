package com.talib.hibernate.cache;

import com.talib.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevelCache {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // FIRST SESSION
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, 4);
        System.out.println(student);
        session.close();

        // SECOND SESSION
        Session session2 = sessionFactory.openSession();
        Student student2 = session2.get(Student.class, 4);
        System.out.println(student2);
        session2.close();

    }
}
