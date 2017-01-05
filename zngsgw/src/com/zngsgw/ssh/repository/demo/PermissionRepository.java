package com.zngsgw.ssh.repository.demo;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zngsgw.ssh.entity.demo.Permission;

public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long>,
		JpaSpecificationExecutor<Permission>,CrudRepository<Permission,Long>{
	public Permission findByPermissionName(String permissionName);
}
