package quanLi.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quanLi.dao.UserDAO;
import quanLi.model.Users;
@Service
public class UserService {
	final static Logger log = Logger.getLogger(StudentService.class);
	@Autowired
	private UserDAO<Users> userDAO;
	public List<Users> findByProperty(String property, Object value){
		log.info("Finding student start");
		return userDAO.findByProperty(property, value); 
	}
}
