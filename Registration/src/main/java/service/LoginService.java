package service;

import java.util.List;

public interface LoginService<T> {
	void save(T t);

	void update(T t);

	void delete(T t);

	List<T> getAllData();

	T getDataById(int id);
}
