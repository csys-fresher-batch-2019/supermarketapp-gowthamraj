package project.dao;

import exception.DbException;
import project.model.Login;

public interface LoginDAO {
	
	void add(Login login) throws DbException;
	public Login check(Login login) throws DbException;
}
