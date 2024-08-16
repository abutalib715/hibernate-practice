package com.talib.hibernate.hql;

import com.talib.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HqlExample {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // FETCHING DATA
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

        System.out.printf("____________________________");

        Transaction trx = session.beginTransaction();

//        // DELETE DATA
//        Query q2 = session.createQuery("delete from Student where city=:city");
//        q2.setParameter("city", "CTG");
//        int uc = q2.executeUpdate();
//        System.out.println(uc + " items deleted");

        // UPDATE DATA
        Query q2 = session.createQuery("update Student set city = :city where name = :name");
        q2.setParameter("city", "Khulna");
        q2.setParameter("name", "Bablu");
        int uc = q2.executeUpdate();
        System.out.println(uc + " items updated");

        trx.commit();
        session.close();
        sessionFactory.close();
    }
}
