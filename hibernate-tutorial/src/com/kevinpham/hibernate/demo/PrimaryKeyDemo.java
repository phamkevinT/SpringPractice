package com.kevinpham.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kevinpham.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {

			// Create 3 student object
			System.out.println("Creating 3 new student object...");
			Student tempStudent1 = new Student("John", "Doe", "john@doe.com");
			Student tempStudent2 = new Student("Mary", "Public", "mary@public.com");
			Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@applebum.com");


			// Start a transaction
			session.beginTransaction();

			// Save the student object
			System.out.println("Saving the student object...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);


			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			// Close factory
			factory.close();
		}
	}

}
