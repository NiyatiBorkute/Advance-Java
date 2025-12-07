package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {
	boolean addNewElement();

	List<Product> getAllProduct();

	List<Product> getByCategory(int cid);

	Product getByPid(int pid);

	boolean deleteById(int pid);

	boolean modifyById(int pid, double price);

	List<Product> sortByPrice();

	

}
