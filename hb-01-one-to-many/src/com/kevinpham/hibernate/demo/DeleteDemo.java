package com.kevinpham.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kevinpham.hibernate.demo.entity.Instructor;
import com.kevinpham.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {

			// Start a transaction
			session.beginTransaction();

			// Get the instructor by their primary key / id
			int theId = 2;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println("Found instructor: " + tempInstructor);

			// Delete the instructor
			// Will also delete record from the associated 'details table'
			if (tempInstructor != null) {
				System.out.println("Deleting: " + tempInstructor);
				session.delete(tempInstructor);
			}

			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			// Close factory
			factory.close();
		}

	}

}
