package com.springsecurity.dao;

import com.springsecurity.entity.DbUser;

public interface UserDao {

	public DbUser getDatabase(String username);
}
