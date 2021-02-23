package com.kevinpham.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kevinpham.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 2;

			// Start a transaction
			session.beginTransaction();

			// Getting the student
			Student myStudent = session.get(Student.class, studentId);

			// Deleting the student
			System.out.println("Deleting student with ID " + studentId);
			session.delete(myStudent);
			
			// Alternate Approach using Query
//			session.createQuery("delete from Student where id=2").executeUpdate();

			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			// Close factory
			factory.close();
		}

	}

}
