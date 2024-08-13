package com.talib.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // CREATE NEW QUESTION OBJ
        Question question = new Question();
        question.setQuestion("What is programming");

        Answer answer = new Answer();
        answer.setAnswer("Test Advanced Java");
        answer.setQuestion(question); // Set the question in the answer

        question.setAnswer(answer); // Set the answer in the question

        Transaction tx = session.beginTransaction();
        session.save(question); // Save question, which cascades to answer
        session.save(answer); // Save question, which cascades to answer
        tx.commit();

        // FETCHING DATA
        Question data = session.get(Question.class, 1);
        System.out.println(data.getQuestion());
        System.out.println(data.getAnswer().getAnswer());

        session.close();
        sessionFactory.close();
    }
}
