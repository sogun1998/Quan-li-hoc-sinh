package quanLi.dao;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional(rollbackFor =Exception.class)
public class BaseDAOImple<E> implements BaseDAO<E>{

	final static Logger log = Logger.getLogger(BaseDAOImple.class);
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<E> findAll() {
		log.info("Find all record from db");
		StringBuilder queryString = new StringBuilder("");
		queryString.append(" from").append(getGenericName()).append(" as model");
		// ghep cau lenh SQL : from <tenbang> as model
		return sessionFactory.getCurrentSession().createQuery(queryString.toString()).list();
	}

	@Override
	public E findById(Class<E> e, Serializable id) {
		// TODO Auto-generated method stub
		log.info("Finding by ID");
		
		return sessionFactory.getCurrentSession().get(e, id);
	}
	public List<E> findByProperty(String property, Object value){
		log.info("Finding by property");
		StringBuilder queryString = new StringBuilder();
		queryString.append(" from ").append(getGenericName()).append(" as model where model.").append(property).append(" =?");
		Query<E> query = sessionFactory.getCurrentSession().createQuery(queryString.toString());
		query.setParameter(0, value);
		return query.getResultList();
		
		
	}

	@Override
	public void save(E instante) {
		// TODO Auto-generated method stub
		log.info("Save");
		sessionFactory.getCurrentSession().persist(instante);
		
	}

	@Override
	public void update(E instanse) {
		// TODO Auto-generated method stub
		log.info("updating");
		sessionFactory.getCurrentSession().merge(instanse);
	}

	public String getGenericName(){
		String s = getClass().getGenericSuperclass().toString();
		Pattern pattern = Pattern.compile("\\<(.*?)\\>");
		
		Matcher m = pattern.matcher(s);
		String generic="null";
		if(m.find()) {
			generic = m.group(1);
		}
		return generic;
	}

}
