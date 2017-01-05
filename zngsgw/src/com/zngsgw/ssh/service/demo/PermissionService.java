package com.zngsgw.ssh.service.demo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zngsgw.ssh.entity.demo.Permission;
import com.zngsgw.ssh.repository.demo.PermissionRepository;

@Service("permissionService")
@Transactional
public class PermissionService implements PermissionServiceI {

	@Resource
	private PermissionRepository permissionRepository;
	


    public void save(Permission permission) {  
    	permissionRepository.save(permission); 
    }

    public void update(Permission permission) {
    	Permission permission2=this.findById(permission.getId());
    	BeanUtils.copyProperties(permission, permission2);
    	permissionRepository.save(permission2);
	}

    @Transactional(readOnly = true)
	public List<Permission> findAllList() {
		 return (List<Permission>) permissionRepository.findAll();
	}

	public Permission findById(Long id) {
		Permission permission=permissionRepository.findOne(id);
		return permission;
	}

	public void delete(Long id) {
		permissionRepository.delete(id);
	}

	public Permission findByPermissionName(String permissionName) {
		return permissionRepository.findByPermissionName(permissionName);
	}
}
