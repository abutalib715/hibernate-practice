package com.talib.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Project Running...");

        Configuration configuration = new Configuration();
        configuration.configure();
//        configuration.configure("hibernate.cfg.xml"); // if file name or location customized

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        System.out.println(sessionFactory);
        System.out.println(sessionFactory.isClosed());
    }
}