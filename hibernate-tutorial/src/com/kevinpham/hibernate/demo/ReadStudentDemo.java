package com.kevinpham.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kevinpham.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Daffy", "Duck", "daffy@duck.com");

			// Start a transaction
			session.beginTransaction();

			// Save the student object
			System.out.println("Saving the student object...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// Commit transaction
			session.getTransaction().commit();
			
			
			// Find our the student's ID -> primary key
			System.out.println("Saved student. Generated ID: " + tempStudent.getId());
			
			// Now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Retrieve student base on the ID / Primary Key
			System.out.println("\nGetting student with id " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("\tGet complete: " + myStudent);
			
			// Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			// Close factory
			factory.close();
		}

	}

}
