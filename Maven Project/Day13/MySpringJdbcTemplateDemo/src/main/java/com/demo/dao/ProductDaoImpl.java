package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean save(Product p) {
		// TODO Auto-generated method stub
		int n=jdbcTemplate.update("insert into product1 values(?,?,?,?,?,?)",new Object[] {p.getPid(),p.getPname(),p.getQty(),p.getPrice(),p.getMfgdate(),p.getCid()});
		return n>0;
	
	}

	@Override
	public List<Product> findAllProduct() {
		List<Product>plist=jdbcTemplate.query("select * from product1", (rs,n)-> {
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getDouble(4));
			if(rs.getDate(5)==null) {
				p.setMfgdate(null);
			}else {
				p.setMfgdate(rs.getDate(5).toLocalDate());
			}
			p.setCid(rs.getInt(6));
			return p;
			
		});
		return plist;
	}

	@Override
	public List<Product> findByCid(int cid) {
		List<Product>plist=jdbcTemplate.query("Select * from product1 where cid=?",new Object[] {cid},(rs,numrows)->{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getDouble(4));
			if(rs.getDate(5)==null) {
				p.setMfgdate(null);
			}else {
				p.setMfgdate(rs.getDate(5).toLocalDate());
			}
			p.setCid(rs.getInt(6));
			return p;
			});
			
		
		return plist;
}

	@Override
	public Product findByPid(int pid) {
	    try {
			Product p=jdbcTemplate.queryForObject("select * from product1 where pid =?",new Object[]{pid},BeanPropertyRowMapper.newInstance(Product.class));
			return p;
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean removeById(int pid) {
		int n=jdbcTemplate.update("delete from product1 where pid=?",new Object[] {pid});
		return n>0 ;
	}

	@Override
	public boolean updateById(int pid,double price) {
		int n=jdbcTemplate.update("update product1 set price=? where pid=?",new Object[] {price,pid});
		return n>0;
	}

	@Override
	public List<Product> arrangeByPrice() {
		List<Product>plist=jdbcTemplate.query("select * from product1 order by price",(rs,n)->{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getDouble(4));
			if(rs.getDate(5)==null) {
				p.setMfgdate(null);
			}
			else {
				p.setMfgdate(rs.getDate(5).toLocalDate());
			}
			p.setCid(rs.getInt(6));
			return p;
		});
		return plist;
	}
}
