package com.kevinpham.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kevinpham.hibernate.demo.entity.Course;
import com.kevinpham.hibernate.demo.entity.Instructor;
import com.kevinpham.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {

		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {

			// Start a transaction
			session.beginTransaction();

			// Get instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			// Create some courses
			Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
			Course tempCourse2 = new Course("The Pinball Masterclass");

			// Add courses to instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);

			// Save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);

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
