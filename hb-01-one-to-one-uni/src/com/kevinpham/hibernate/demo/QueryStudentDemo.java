package com.kevinpham.hibernate.demo;

import java.util.List;

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

			// Start a transaction
			session.beginTransaction();

			// Query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
					// Display the students
					displayStudents(theStudents);
			
			// Query students: lastName='Doe'
			theStudents = session.createQuery("from Student s where s.lastname='Doe'").getResultList();
			
					// Display the students
					System.out.println("\n\nStudents who have the last name of 'Doe'");
					displayStudents(theStudents);
			
			// Query students: lastName='Doe' or firstName='Daffy'
			theStudents = session.createQuery("from Student s where s.lastname='Doe' OR s.firstName='Daffy'").getResultList();
			
					// Display the students
					System.out.println("\n\nStudents who have the last name of 'Doe' or first name of 'Daffy'");
					displayStudents(theStudents);
			
			// Query students: where email LIKE '%pham.com'
			theStudents = session.createQuery("FROM Student s WHERE s.email LIKE '%pham.com'").getResultList();
			
					// Display the students
					System.out.println("\n\nStudents who have the email ending in 'pham.com'");
					displayStudents(theStudents);
					
					
					
					
			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
			
		} finally {
			// Close factory
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
