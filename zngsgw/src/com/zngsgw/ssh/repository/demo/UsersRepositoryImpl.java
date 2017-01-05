package com.zngsgw.ssh.repository.demo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UsersRepositoryImpl{

	@PersistenceContext
	private EntityManager em;
}
