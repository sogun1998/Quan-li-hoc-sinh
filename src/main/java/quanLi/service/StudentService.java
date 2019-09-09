package quanLi.service;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quanLi.dao.StudentDAO;

import quanLi.model.Student;

@Service
public class StudentService {
	final static Logger log = Logger.getLogger(StudentService.class);
	@Autowired
	private StudentDAO<Student> studentDAO;
	public void saveStudent(Student student){
		log.info("Insert student "+student.toString());
		studentDAO.save(student);
	}
	public void updateStudent(Student student){
		log.info("Update student "+student.toString());
		studentDAO.update(student);
	}
	public void deleteStudent(Student student){
		student.setName("No");
		log.info("Delete category "+student.toString());
		studentDAO.update(student);
	}
	public List<Student> findStudent(String property , Object value){
		log.info("=====Find by property student start====");
		log.info("property ="+property +" value"+ value.toString());
		return studentDAO.findByProperty(property, value);
	}
}
