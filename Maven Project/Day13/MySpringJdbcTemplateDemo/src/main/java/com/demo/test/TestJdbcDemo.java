package com.demo.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Product;
import com.demo.service.ProductService;

public class TestJdbcDemo {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		ProductService pservice=(ProductService)ctx.getBean("productServiceImpl");
		int choice=0;
		do{
			System.out.println("1. Add new product\n2. display all\n 3. display by category");
			System.out.println("4. display by pid\n");
			System.out.println("5. delete by id\n 6. modify by id\n 7. arrange in sorted order");
			System.out.println("8. exit\n choice :");
			choice=sc.nextInt();
			switch(choice){
			case 1:{
				boolean status=pservice.addNewElement();
				if(status) {
					System.out.println("product added successfully");
				}
				else {
					System.out.println("not added successfully");
				}
				break;
				
			}
			case 2:{
				List<Product>plist=pservice.getAllProduct();
				plist.forEach(System.out::println);
				break;
			}
			case 3:{
				System.out.println("Enter category id");
				int cid=sc.nextInt();
				List<Product>plist=pservice.getByCategory(cid);
				plist.forEach(System.out::println);
				break;
			}
			
			case 4:{
				System.out.println("Enter pid ");
				int pid=sc.nextInt();
				Product p=pservice.getByPid(pid);
				if(p!=null) {
					System.out.println(p);
				}else {
					System.out.println("pid Not found");
				}
				break;
				
			}
			case 5:{
				System.out.println("Enter pid");
				int pid=sc.nextInt();
				boolean status=pservice.deleteById(pid);
				if(status) {
					System.out.println("delete successfully");
				}else {
					System.out.println("not find");
				}
				break;
			}
			case 6:{
				System.out.println("Enter pid");
				int pid=sc.nextInt();
				System.out.println("Enter price");
				double price=sc.nextInt();
				boolean status=pservice.modifyById(pid,price);
				
				if(status) {
					System.out.println("Modify Succesfully");
				}else {
					System.out.println("not found");
					
				}
				break;
			}
			case 7:{
				List<Product>plist=pservice.sortByPrice();
				plist.forEach(System.out::println);
				break;
			}
			case 8:{
				System.out.println("Thank you for visit");
			}
			}
		}while(choice!=8);
		
		
		
	}

}
