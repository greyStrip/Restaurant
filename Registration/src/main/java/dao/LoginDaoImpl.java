package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import model.User;

public class LoginDaoImpl implements LoginDao<User> {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public void save(User t) {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
	}

	@Override
	@Transactional
	public void update(User t) {
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
	}

	@Override
	@Transactional
	public void delete(User t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
	}

	@Override
	@Transactional
	public List<User> getAllData() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<User> users = session.createQuery("from User", User.class).getResultList();
		return users;
	}

	@Override
	@Transactional
	public User getDatabyId(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		return user;
	}

}
