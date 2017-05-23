package com.amirbhujel.DemoHib.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.amirbhujel.DemoHib.model.Employee;

public class HqlDriver {
	
	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		session.beginTransaction();
		
		int id = 45;
		
		String hql1 = "FROM Employee";
		String hql2 = "FROM Employee WHERE empid = 23";
		String hql3 = "SELECT empId, fName, position FROM Employee where empId = 23";
		String hql4 = "SELECT empId, fName, position FROM Employee";
		String hql5 = "SELECT empId, fName, position FROM Employee e where e.empId = 23";
		String hql6 = "SELECT SUM(salary) FROM Employee e where e.empId = 23";
		String hql7 = "SELECT SUM(salary) FROM Employee e where e.empId =" + id;
		String hql8 = "SELECT SUM(salary) FROM Employee e where e.empId = :x"; // q8.setParameter("x", id);
		
		Query q1 = session.createQuery(hql1);
		List<Employee> employees=  q1.list();
		
		for(Employee emp : employees){
			System.out.println(emp);
		}
		
		Query q2 = session.createQuery(hql2);
		Employee employee = (Employee) q2.uniqueResult();
		System.out.println(employee);
		
		Query q3 = session.createQuery(hql3);
		Object[] empl = (Object[]) q3.uniqueResult();
		
		for(Object o : empl){
			System.out.println(o);
		}
		
		Query q4 = session.createQuery(hql4);
		List<Object[]> empls = (List<Object[]>) q4.uniqueResult();
		
		for(Object[] emplo : empls){
			System.out.println(emplo[0] + ":" + emplo[1] + ":" + emplo[2]);
		}
		
		session.getTransaction().commit();
		session.close();
	}

}
