package com.zngsgw.ssh.service.demo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zngsgw.ssh.entity.demo.Role;
import com.zngsgw.ssh.repository.demo.RoleRepository;

@Service("roleService")
@Transactional
public class RoleService implements RoleServiceI {

	@Resource
	private RoleRepository roleRepository;
	


    public void save(Role role) {  
		roleRepository.save(role); 
    }

    public void update(Role role) {
		Role role2=this.findById(role.getId());
		BeanUtils.copyProperties(role, role2);
		roleRepository.save(role2);
	}

    @Transactional(readOnly = true)
	public List<Role> findAllList() {
		 return (List<Role>) roleRepository.findAll();
	}

	public Role findById(Long id) {
		Role role=roleRepository.findOne(id);
		return role;
	}

	public void delete(Long id) {
		roleRepository.delete(id);
	}
	
	public Role findByRoleName(String roleName) {
		return roleRepository.findByRoleName(roleName);
	}

}
