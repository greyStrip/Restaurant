package dao;

import java.util.List;

public interface LoginDao<T> {
	void save(T t);

	void update(T t);

	void delete(T t);

	List<T> getAllData();

	T getDatabyId(int id);
}
