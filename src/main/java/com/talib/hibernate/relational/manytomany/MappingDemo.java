package com.talib.hibernate.relational.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MappingDemo {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // CREATE NEW EMP OBJ
        Employee emp1 = new Employee();
        emp1.setName("Akash");
        Employee emp2 = new Employee();
        emp2.setName("Batash");

//         CREATE NEW ANSWER OBJ
        Project pro1 = new Project();
        pro1.setProjectName("Chatbot");
        Project pro2 = new Project();
        pro2.setProjectName("Traffic Checker");

        List<Project> projects = new ArrayList<>();
        projects.add(pro1);
        projects.add(pro2);
        emp1.setProjects(projects);

        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        pro1.setEmployees(employees);

        Transaction tx = session.beginTransaction();
        session.save(emp1);
        session.save(emp2);
        session.save(pro1);
        session.save(pro2);
        tx.commit();

        // FETCHING DATA
        Employee data = session.get(Employee.class, 1);
        System.out.println(data.getName());
        for (Project answer : data.getProjects()) {
            System.out.printf(answer.getProjectName());
        }

        session.close();
        sessionFactory.close();
    }
}
