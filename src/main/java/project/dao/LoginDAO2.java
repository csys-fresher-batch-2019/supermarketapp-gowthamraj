package project.dao;

import project.model.Login;

public interface LoginDAO2 {
	public void add(Login l);
    Login login(String username, String password);

}
