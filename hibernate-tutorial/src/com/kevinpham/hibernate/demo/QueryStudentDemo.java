package com.kevinpham.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kevinpham.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {

			// Create student object
			System.out.println("Creating a new student object...");
			Student tempStudent = new Student("Kevin", "Pham", "kevin@pham.com");

			// Start a transaction
			session.beginTransaction();

			// Save the student object
			System.out.println("Saving the student object...");
			session.save(tempStudent);
			
			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
			
		} finally {
			// Close factory
			factory.close();
		}

	}

}
