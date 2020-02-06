package com.chainsys.supermarketapp.dao;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Login;

public interface LoginDAO {
	
	void add(Login login) throws DbException;
	public Login check(Login login) throws DbException;
}
