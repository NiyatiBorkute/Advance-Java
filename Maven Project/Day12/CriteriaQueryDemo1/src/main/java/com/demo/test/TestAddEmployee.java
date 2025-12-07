package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Employee;

public class TestAddEmployee {
	public static void main(String[] args) {
	
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session session =sf.openSession();
	Transaction tr=session.beginTransaction();
	Employee e1=new Employee("niyati",45658,"HR",23);
	Employee e2=new Employee("yukti",45656,"Hffdh",24);
	Employee e3=new Employee("swati",45654,"HRb",25);
	Employee e4=new Employee("kruti",45058,"HRbgfnj",26);
	Employee e5=new Employee("nitya",65658,"HRbngfn",27);
	session.save(e1);
	session.save(e2);
	session.save(e3);
	session.save(e4);
	session.save(e5);
	tr.commit();
	session.close();
	sf.close();

}
}
