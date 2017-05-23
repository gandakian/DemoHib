package com.amirbhujel.DemoHib.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.amirbhujel.DemoHib.model.Employee;

public class CacheFirstLvl {
	
	public static void main(String[] args) {
		
		Employee emp = null;
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session1 = sf.openSession();
		session1.beginTransaction();
		
		emp = (Employee) session1.get(Employee.class, 101);  // Pulls from the Employee table with id 101
		System.out.println(emp);
		emp = (Employee) session1.get(Employee.class, 101); // Fires query only once i.e. above one
		System.out.println(emp);
		
		session1.getTransaction().commit();
		session1.close();
		
		Session session2 = sf.openSession();
		session2.beginTransaction();
		
		emp = (Employee) session2.get(Employee.class, 101); // Will have to fire query again due to a new session
		System.out.println(emp);
		
		session2.getTransaction().commit();
		session2.close();
		
		
	}

}
