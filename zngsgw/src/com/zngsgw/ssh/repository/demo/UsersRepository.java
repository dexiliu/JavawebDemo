package com.zngsgw.ssh.repository.demo;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zngsgw.ssh.entity.demo.Users;

public interface UsersRepository extends PagingAndSortingRepository<Users, Long>,
		JpaSpecificationExecutor<Users>,CrudRepository<Users,Long>{
	public Users findByUsername(String userName);
}
