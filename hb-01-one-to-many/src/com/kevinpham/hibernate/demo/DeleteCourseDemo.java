package com.kevinpham.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kevinpham.hibernate.demo.entity.Course;
import com.kevinpham.hibernate.demo.entity.Instructor;
import com.kevinpham.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

	public static void main(String[] args) {

		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {

			// Start a transaction
			session.beginTransaction();

			
			// Get a course
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			
			// Delete the course
			System.out.println("Deleting Course: " + tempCourse);
			session.delete(tempCourse);
			
		
			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			// Clean up resources
			session.close();
			factory.close();
		}

	}

}
