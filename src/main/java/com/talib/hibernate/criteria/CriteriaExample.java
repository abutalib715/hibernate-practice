package com.talib.hibernate.criteria;

import com.talib.hibernate.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CriteriaExample {
    public static void main(String[] args) {
        Session session = new Configuration().configure().buildSessionFactory().openSession();

        Criteria c = session.createCriteria(Student.class);
        c.add(Restrictions.eq("certificate.course", "Java"));
//        c.add(Restrictions.gt("id", 4));
//        c.add(Restrictions.like("certificate.course", "%Java%"));
        List<Student> studentList = c.list();

        for (Student student : studentList) {
            System.out.println(student);
        }

        session.close();
    }
}
