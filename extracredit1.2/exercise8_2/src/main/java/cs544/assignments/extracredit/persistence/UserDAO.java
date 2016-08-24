package cs544.assignments.extracredit.persistence;

import cs544.assignments.extracredit.model.User;

public interface UserDAO {
	public void save(User user);
	public void delete(User user);
	public User getUserById(int userId);
	public User getUserByUsername(String username);

}
