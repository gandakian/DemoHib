package com.amirbhujel.DemoHib.main;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
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
		
		String sql1 = "SELECT * FROM employee WHERE empid = 25";
		String sql2 = "SELECT fName, position FROM employee WHERE empid = 25";
		
		SQLQuery query1 = session.createSQLQuery(sql1);
		query1.addEntity(Employee.class);
		List<Employee> emps1 = query1.list();
		
		for(Employee e : emps1){
			System.out.println(e);
		}
		
		SQLQuery query2 = session.createSQLQuery(sql2);
		query2.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List emps2 = query2.list();
		
		for(Object o : emps2){
			Map m = (Map) o;
			System.out.println(m.get("fName") + ":" + m.get("position") );
		}
		
		session.getTransaction().commit();
		session.close();
		
	}

}
