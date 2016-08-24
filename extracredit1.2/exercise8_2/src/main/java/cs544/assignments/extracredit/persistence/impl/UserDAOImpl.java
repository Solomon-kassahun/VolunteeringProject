package cs544.assignments.extracredit.persistence.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.assignments.extracredit.model.User;
import cs544.assignments.extracredit.persistence.UserDAO;

public class UserDAOImpl implements UserDAO {
	SessionFactory sessionFactory;
	
	public UserDAOImpl(){}
	
	public UserDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);

	}

	@Override
	public User getUserById(int userId) {
		return (User)sessionFactory.getCurrentSession().get(User.class, userId);
	}

	@Override
	public User getUserByUsername(String userId) {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT u from User u WHERE u.username = :username");
		query.setParameter("username", userId);
		List<User> users = query.list();
		if(!users.isEmpty()){
			return users.get(0);
		}
		return null;
	}

}
