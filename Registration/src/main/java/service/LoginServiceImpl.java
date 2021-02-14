package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.LoginDao;
import model.User;

public class LoginServiceImpl implements LoginService<User> {
	@Autowired
	LoginDao<User> loginDao;

	@Override
	public void save(User t) {
		loginDao.save(t);
	}

	@Override
	public void update(User t) {
		loginDao.update(t);
	}

	@Override
	public void delete(User t) {
		loginDao.delete(t);
	}

	@Override
	public List<User> getAllData() {
		return loginDao.getAllData();
	}

	@Override
	public User getDataById(int id) {
		// TODO Auto-generated method stub
		return loginDao.getDatabyId(id);
	}

}
