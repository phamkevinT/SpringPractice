package com.kevinpham.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kevinpham.hibernate.demo.entity.Instructor;
import com.kevinpham.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {

			// Create the objects
//			Instructor tempInstructor = new Instructor("Kevin", "Pham", "kevin@pham.com");
//			InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.youtube.com", "Aquarium Fish Keeping");
			
			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.luv2code.com/youtube", "Luv 2 Code!");
			
			// Associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// Start a transaction
			session.beginTransaction();

			// Save the objects 
			// This will also save the details object because of the CascadeType.ALL annotation
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			// Close factory
			factory.close();
		}

	}

}
