package com.talib.hibernate.cascade;

import com.talib.hibernate.relational.Answer;
import com.talib.hibernate.relational.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CascadeExample {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // CREATE NEW QUESTION OBJ
        Question q1 = new Question();
        q1.setQuestion("What is Database?");

        // CREATE NEW ANSWER OBJ
        Answer ans1 = new Answer("SQL",q1);
        Answer ans2 = new Answer("HQL",q1);

        List<Answer> answers = new ArrayList<>();
        answers.add(ans1);
        answers.add(ans2);

        q1.setAnswers(answers);

        session.persist(q1);

        Transaction tx = session.beginTransaction();
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
