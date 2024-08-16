package com.talib.hibernate.hql;

import com.talib.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class HqlNativeExample {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // FETCHING DATA
        NativeQuery<Student> query = session.createNativeQuery("select * from student", Student.class);
        List<Student> studentList = query.list();

        for (Student student : studentList) {
            System.out.println(student.getName());
        }

        session.close();
        sessionFactory.close();
    }
}
