package com.talib.hibernate.cache;

import com.talib.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelCache {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Student student = session.get(Student.class, 4);
        System.out.println(student);
        System.out.println("Working on Something.....");
        Student student2 = session.get(Student.class, 4); // IT WILL SERVE FROM SESSION CACHE (FIRST LEVEL CACHE)
        System.out.println(student2);

        System.out.println(session.contains(student)); // check if data exist in session cache

        session.close();
    }
}
