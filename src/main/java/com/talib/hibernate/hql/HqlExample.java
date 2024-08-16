package com.talib.hibernate.hql;

import com.talib.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HqlExample {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        String query = "from Student where city = :city ";
        Query q = session.createQuery(query);
        q.setParameter("city", "CTG");
        // single - Unique()
        // multiple - list()

        List<Student> studentList = q.list();
//        Student student = (Student) q.uniqueResult();

//        System.out.println(student.getName());
        for (Student student : studentList) {
            System.out.println(student.getName());
        }

        session.close();
        sessionFactory.close();
    }
}
