package com.kevinpham.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kevinpham.hibernate.demo.entity.Instructor;
import com.kevinpham.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {

			// Start a transaction
			session.beginTransaction();

			// Get the instructor detail object
			int theId = 1;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			// Print the instructor detail
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);

			// Print the associated instructor
			System.out.println("The associated instructor: " + tempInstructorDetail.getIntructor());
			
//			// Remove the associated object reference
//			// Break bi-directional link (deleting details record wont delete from instructor)
//			tempInstructorDetail.getIntructor().setInstructorDetail(null);
			
			
//			// Delete the instructor detail
//			System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);
//			session.delete(tempInstructorDetail);

			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			// Close Resources
			session.close();
			factory.close();
		}

	}

}
