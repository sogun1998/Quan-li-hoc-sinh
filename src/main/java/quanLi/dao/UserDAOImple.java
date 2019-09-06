package quanLi.dao;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quanLi.model.Users;

@Repository
@Transactional(rollbackFor=Exception.class)
public class UserDAOImple extends BaseDAOImple<Users> implements UserDAO<Users> {

}
