package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Address1;
import com.demo.beans.Employee;
import com.demo.beans.HelloWorld11;
import com.demo.beans.MyUser1;

public class TestHelloWorld {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springcfg.xml");
		
		HelloWorld11 hellow=(HelloWorld11)ctx.getBean("hw");
		String msg=hellow.sayHello();
		System.out.println(msg);
		
		Employee e=(Employee)ctx.getBean("emp1");
		System.out.println(e);
		
		Employee e1= (Employee)ctx.getBean("emp2");
		System.out.println(e1);
		
		MyUser1 u=(MyUser1)ctx.getBean("u1");
		System.out.println(u);
		
		Address1 ad=(Address1)ctx.getBean("ad1");
		System.out.println(ad);
	}

}
