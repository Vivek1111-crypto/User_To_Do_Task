package in.ashokit.service;

import in.ashokit.Entity.User;

public interface UserService {

	public boolean register(User user);
	public User login(String email,String password);
	
}
