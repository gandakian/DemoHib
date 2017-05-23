package com.amirbhujel.DemoHib.main;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.amirbhujel.DemoHib.model.Employee;

public class CacheSecondLvl {

	public static void main(String[] args) {


		Employee emp = null;

		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session1 = sf.openSession();
		session1.beginTransaction();

		// 2nd Level Caching with Query
		Query q1 = session1.createQuery("FROM Employee WHERE empId=101");
		q1.setCacheable(true);
		emp = (Employee) q1.uniqueResult();

		emp = (Employee) session1.get(Employee.class, 101);  // Pulls from the Employee table with id 101
		System.out.println(emp);

		session1.getTransaction().commit();
		session1.close();

		Session session2 = sf.openSession();
		session2.beginTransaction();

		// 2nd Level Caching with Query
		Query q2 = session2.createQuery("FROM Employee WHERE empId=101");
		q2.setCacheable(true);
		emp = (Employee) q2.uniqueResult();

		emp = (Employee) session2.get(Employee.class, 101); // Fires query only once i.e. above one due to 2nd level caching
		System.out.println(emp);

		session2.getTransaction().commit();
		session2.close();
	}

}
