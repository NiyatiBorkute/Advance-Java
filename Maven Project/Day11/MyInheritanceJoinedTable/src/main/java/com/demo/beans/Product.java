package com.demo.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name="myproduct1")
@Inheritance(strategy=InheritanceType.JOINED)
public class Product {
	@Id
	private int pid;
	private String pname;
	private int qty;
	private double price;
	private LocalDate mgfdate;
	public Product() {
		super();
	}
	public Product(int pid, String pname, int qty, double price, LocalDate mgfdate) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		this.mgfdate = mgfdate;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getMgfdate() {
		return mgfdate;
	}
	public void setMgfdate(LocalDate mgfdate) {
		this.mgfdate = mgfdate;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", price=" + price + ", mgfdate=" + mgfdate
				+ "]";
	}
	
	

}
