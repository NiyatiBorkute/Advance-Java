package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	boolean save(Product p);

	List<Product> findAllProduct();

	List<Product> findByCid(int cid);

	Product findByPid(int pid);

	boolean removeById(int pid);

	boolean updateById(int pid, double price);

	List<Product> arrangeByPrice();

}
