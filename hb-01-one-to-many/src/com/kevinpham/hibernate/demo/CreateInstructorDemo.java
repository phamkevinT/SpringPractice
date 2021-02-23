package com.kevinpham.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kevinpham.hibernate.demo.entity.Course;
import com.kevinpham.hibernate.demo.entity.Instructor;
import com.kevinpham.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {

			// Create the objects
			Instructor tempInstructor = new Instructor("Susan", "Public", "susan@public.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.youtube.com", "Video Games");

			// Associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// Start a transaction
			session.beginTransaction();

			// Save the objects
			// This will also save the details object because of the CascadeType.ALL
			// annotation
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);

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
