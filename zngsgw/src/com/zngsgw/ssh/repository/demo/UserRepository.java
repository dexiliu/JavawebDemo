package com.zngsgw.ssh.repository.demo;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zngsgw.ssh.entity.demo.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>,
		JpaSpecificationExecutor<User>,CrudRepository<User,Long>{
	public User findByUserName(String userName);
}
