package com.talib.hibernate.relational;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapDemo {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // CREATE NEW QUESTION OBJ
        Question q1 = new Question();
        q1.setQuestion("What is programming");

        // CREATE NEW ANSWER OBJ
        Answer ans1 = new Answer();
        ans1.setAnswer("Test Advanced Java");
        ans1.setQuestion(q1);

        Answer ans2 = new Answer();
        ans2.setAnswer("Advanced PHP");
        ans2.setQuestion(q1);

        List<Answer> answers = new ArrayList<>();
        answers.add(ans1);
        answers.add(ans2);
        q1.setAnswers(answers); // Set the answer in the question

        Transaction tx = session.beginTransaction();
        session.save(q1);
        session.save(ans1);
        session.save(ans2);
        tx.commit();

        // FETCHING DATA
        Question data = session.get(Question.class, 1);
        System.out.println(data.getQuestion());
        for (Answer answer : data.getAnswers()) {
            System.out.printf(answer.getAnswer());
        }

        session.close();
        sessionFactory.close();
    }
}
