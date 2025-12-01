package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.MyUser;
import com.demo.beans.Product;

public class TestMyUser {
	public static void main(String[] args) {
		//create Session Factory
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		//create a MyUser object
		MyUser u1=new MyUser(1,"niyati","niyati@123");
		MyUser u2=new MyUser(2,"yash","yash30jan@245");
		Product p1=new Product(5, "table",23,54000);
		Product p2=new Product(6,"chair",30,4000);
		
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		
		session.save(u1);
		session.save(u2);
		session.save(p1);
		session.save(p2);
		
		tr.commit();
		session.close();
		sf.close();
	}

}
