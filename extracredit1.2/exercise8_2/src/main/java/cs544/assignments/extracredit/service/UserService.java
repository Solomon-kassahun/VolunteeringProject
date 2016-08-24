package cs544.assignments.extracredit.service;

import cs544.assignments.extracredit.model.User;

public interface UserService {
	public User findUserById(int id);
	public User findUserByUsername(String username);

}
