package project.dao;

import project.model.Login;

public interface LoginDAO {
	
	void add(Login login) throws Exception;
	public Login check(Login login) throws Exception;

}
