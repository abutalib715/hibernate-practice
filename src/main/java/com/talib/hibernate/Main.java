package com.talib.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Project Running...");

        Configuration configuration = new Configuration();
        configuration.configure();
//        configuration.configure("hibernate.cfg.xml"); // if file name or location customized
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // CREATE NEW STUDENT OBJ
        Student student = new Student();
        student.setName("Lablu");
        student.setCity("CTG");

//        // CREATE NEW ADDRESS OBJ
        Address address = new Address();
        address.setStreet("790/1");
        address.setCity("CTG");
        address.setIsOpen(true);
        address.setAddedDate(new Date());
        address.setX(343.88);

        FileInputStream inputStream = new FileInputStream("src/main/resources/logo.png");
        byte[] imageData = inputStream.readAllBytes();;
        address.setImage(imageData);

        // GET CURRENT SESSION AND SAVE DATA
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        session.save(student);
        session.save(address);
        tx.commit();
        sessionFactory.close();
        System.out.println("Done....");
    }
}
