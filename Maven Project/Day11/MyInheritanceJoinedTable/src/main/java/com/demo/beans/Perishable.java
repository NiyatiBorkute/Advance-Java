package com.demo.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="perishable")
public class Perishable extends Product{
	private LocalDate expdate;

	public Perishable() {
		super();
	}

	public Perishable(int pid, String pname, int qty, double price, LocalDate mgfdate,LocalDate expdate) {
		super(pid, pname, qty, price, mgfdate);
		this.expdate = expdate;
		
	}

	public LocalDate getExpdate() {
		return expdate;
	}

	public void setExpdate(LocalDate expdate) {
		this.expdate = expdate;
	}

	@Override
	public String toString() {
		return super.toString()+ "Perishable [expdate=" + expdate + "]";
	}
	

	
	

}
