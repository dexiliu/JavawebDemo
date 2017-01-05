package com.zngsgw.ssh.repository.demo;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zngsgw.ssh.entity.demo.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long>,
		JpaSpecificationExecutor<Role>,CrudRepository<Role,Long>{
	public Role findByRoleName(String roleName);
}
