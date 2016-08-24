/**
 * 
 */
package cs544.assignments.extracredit.service.impl;

import org.springframework.stereotype.Service;

import cs544.assignments.extracredit.model.User;
import cs544.assignments.extracredit.persistence.UserDAO;
import cs544.assignments.extracredit.service.UserService;

/**
 * @author Solomon Kassahun
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	UserDAO userDAO;
	
	public UserServiceImpl(){}
	public UserServiceImpl(UserDAO userDAO){
		this.userDAO = userDAO;
	}

	/* (non-Javadoc)
	 * @see cs544.assignments.extracredit.service.UserService#findUserById(int)
	 */
	@Override
	public User findUserById(int userId) {		
		return userDAO.getUserById(userId);
	}

	/* (non-Javadoc)
	 * @see cs544.assignments.extracredit.service.UserService#findUserByUsername(java.lang.String)
	 */
	@Override
	public User findUserByUsername(String username) {
		return userDAO.getUserByUsername(username);
	}

}
