package com.zngsgw.ssh.service.productIntroduction;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zngsgw.ssh.entity.productIntroduction.Product;
import com.zngsgw.ssh.repository.productIntroduction.ProRepository;

@Service("proService")
@Transactional
public class ProService implements ProServiceI {

	@Resource
	private ProRepository proRepository;
	
	public void save(Product product) {
		proRepository.save(product);
	}

	public void delete(Long id) {
		proRepository.delete(id);
	}

	public void update(Product product) {
		Product product2=this.findById(product.getId());
		BeanUtils.copyProperties(product, product2);
		proRepository.save(product2);
	}

	public Product findById(Long id) {
		Product product=new Product();
		if(id!=null||id!=0){
			product=proRepository.findOne(id);
			return product;
		}else{
			return null;
		}
	}

	public List<Product> findAllList() {
		return (List<Product>) proRepository.findAll();
	}

}
