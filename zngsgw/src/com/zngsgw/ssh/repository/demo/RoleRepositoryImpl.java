package com.zngsgw.ssh.repository.demo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.zngsgw.ssh.entity.demo.User;


public class RoleRepositoryImpl{

	@PersistenceContext
	private EntityManager em;
}
