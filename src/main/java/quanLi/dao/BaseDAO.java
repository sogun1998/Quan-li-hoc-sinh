package quanLi.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<E> {
	public List<E> findAll();// E là kiểu dữ liệu tương ứng với từng class 
	public E findById(Class<E> e,Serializable id);
	public List<E> findByProperty(String property, Object value);
	public void save(E instante);
	public void update(E instanse);
}
