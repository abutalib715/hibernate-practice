package com.talib.hibernate.state;

import com.talib.hibernate.Certificate;
import com.talib.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {
    public static void main(String[] args) {
        // Hibernate/Persistence Lifecycle State Practical:
        //Transient
        //Persistent
        //Detached
        //Removed - Remove from db but available in session

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        //Creating new student obj
        Student student = new Student();
        student.setName("Jahid");
        student.setCity("Dhaka");
        student.setCertificate(new Certificate("Java Advance", "6 Month"));
        //student: Transient state

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student); //student: Persistent - session, database

        student.setName("Dahad"); // Syncing with session and db as session is not closed yet and not commited
        transaction.commit();

        student.setName("Khalid");
        System.out.println(student.getName());

        sessionFactory.close(); //student: Detached
        //Removed - delete before session closed

    }
}
