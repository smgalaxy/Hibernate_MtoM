package org.example;

import java.util.ArrayList;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class StoreData {
    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure("META-INF/hibernate.cfg.xml")
                .addAnnotatedClass(Question.class).addAnnotatedClass(Answer.class);

        SessionFactory factory=cfg.buildSessionFactory();
        //creating session object
        Session session=factory.openSession();
        //creating transaction object
        Transaction t=session.beginTransaction();


        Answer an1=new Answer();
        an1.setAnswername("Java is a programming language");
        an1.setPostedBy("Ravi Malik");

        Answer an2=new Answer();
        an2.setAnswername("Java is a platform");
        an2.setPostedBy("Sudhir Kumar");

        Question q1=new Question();
        q1.setQname("What is Java?");
        ArrayList<Answer> l1=new ArrayList<>();
        l1.add(an1);
        l1.add(an2);
        q1.setAnswers(l1);


        Answer ans3=new Answer();
        ans3.setAnswername("Servlet is an Interface");
        ans3.setPostedBy("Jai Kumar");

        Answer ans4=new Answer();
        ans4.setAnswername("Servlet is an API");
        ans4.setPostedBy("Arun");

        Question q2=new Question();
        q2.setQname("What is Servlet?");
        ArrayList<Answer> l2=new ArrayList<>();
        l2.add(ans3);
        l2.add(ans4);
        q2.setAnswers(l2);



        session.persist(q1);
        session.persist(q2);

        t.commit();
        session.close();
        System.out.println("success");


    }
}