package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao pdao;
	
	
	public boolean addNewElement() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter pid");
		int pid=sc.nextInt();
		System.out.println("Enter pname");
		String pname=sc.next();
		System.out.println("Enter qty");
		int qty=sc.nextInt();
		System.out.println("Enter price");
		double price=sc.nextDouble();
		System.out.println("Enter mfgdate(dd/MM/yyyy)");
		String ldt=sc.next();
		LocalDate mfgdate=LocalDate.parse(ldt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("Enter cid");
		int cid=sc.nextInt();
		Product p=new Product(pid,pname,qty,price,mfgdate,cid);
		return pdao.save(p);
	}


	@Override
	public List<Product> getAllProduct() {
		return pdao.findAllProduct();
	}


	@Override
	public List<Product> getByCategory(int cid) {
		return pdao.findByCid(cid);
	}


	@Override
	public Product getByPid(int pid) {
		
		return pdao.findByPid(pid);
	}


	@Override
	public boolean deleteById(int pid) {
		
		return pdao.removeById(pid);
	}


	@Override
	public boolean modifyById(int pid, double price) {
		
		return pdao.updateById(pid,price);
	}


	@Override
	public List<Product> sortByPrice() {
		// TODO Auto-generated method stub
		return pdao.arrangeByPrice();
	}


	
	
	
	}


