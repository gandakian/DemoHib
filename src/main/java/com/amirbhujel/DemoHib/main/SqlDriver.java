package com.amirbhujel.DemoHib.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.amirbhujel.DemoHib.model.Employee;

public class SqlDriver {
	
	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.getTransaction().commit();
		session.close();
		
	}

}
