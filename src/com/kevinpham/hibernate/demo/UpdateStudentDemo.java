package com.kevinpham.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kevinpham.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;
			
			// Start a transaction
			session.beginTransaction();
			
			// Retrieve student based on id 
			System.out.println("Getting student with ID " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Get complete: " + myStudent);
			
			// Update in memory
			myStudent.setFirstName("Scooby");
			
			
			// Commit transaction 
			session.getTransaction().commit();

			System.out.println("Done!");
			
		} finally {
			// Close factory
			factory.close();
		}

	}

}
