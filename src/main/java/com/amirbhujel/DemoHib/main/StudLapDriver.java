package com.amirbhujel.DemoHib.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.amirbhujel.DemoHib.model.Laptop;
import com.amirbhujel.DemoHib.model.Student;

public class StudLapDriver {
	
	public static void main(String[] args) {
		Laptop laptop = new Laptop();
		laptop.setlId(101);
		laptop.setlName("Dell");
		
		Student student = new Student();
		student.setName("Amir");
		student.setRollNo(1);
		student.setMarks(50);
		
		laptop.setStudent(student);
		laptop.getStudents().add(student);
		
		student.setLaptop(laptop);
		student.getLaptops().add(laptop);
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);

		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(laptop);
		session.save(student);
		session.getTransaction().commit();
		
	}

}
