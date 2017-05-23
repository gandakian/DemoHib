package com.amirbhujel.DemoHib.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.amirbhujel.DemoHib.model.Alien;
import com.amirbhujel.DemoHib.model.AlienName;

/**
 * Hello world!
 */
public class App 
{
	static Configuration con;
	static ServiceRegistry reg;
	static SessionFactory sf;
	static Session session;
	static Transaction tx;

	public static void main( String[] args )
	{

		initAll();
		saveData();

	}

	public static void initAll() {

		//No parameter required in Configure() for default cfg file. Otherwise need to specify
		con = new Configuration().configure().addAnnotatedClass(Alien.class);

		reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		sf = con.buildSessionFactory(reg);

		session = sf.openSession();
	}

	public static void saveData(){

		Alien amir = new Alien();
		amir.setaId(101);
		amir.setaName(new AlienName("Amir", "Bhujel"));
		amir.setaColor("Green");

		tx = session.beginTransaction();
		session.save(amir);
		tx.commit();
	}
	
	public static void viewData(){
		
		Alien amir = new Alien();
		amir = (Alien) session.get(Alien.class, 1);
		
		tx = session.beginTransaction();
		tx.commit();
		
		System.out.println(amir);
	}
}
