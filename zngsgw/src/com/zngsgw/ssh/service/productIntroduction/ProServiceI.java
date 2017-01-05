package com.zngsgw.ssh.service.productIntroduction;

import java.util.List;

import com.zngsgw.ssh.entity.productIntroduction.Product;

public interface ProServiceI {

	public void save(Product product);
	
	public void delete(Long id);
	
	public void update(Product product);
	
	public Product findById(Long id);
	
	public List<Product> findAllList();
}
