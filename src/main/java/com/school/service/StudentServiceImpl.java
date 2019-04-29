package com.school.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.school.model.Student;
import com.school.repository.StudentDaoImpl;
@Service
@Qualifier("studentServiceImpl")
public class StudentServiceImpl implements EntityService<Student> {

private static final Logger log = LogManager.getLogger("com.school.repository.StudentDaoImpl");
	
	@Autowired
	public StudentDaoImpl st;
	@Override
	public Iterable<Student> getAllItems() {
		return st.findAll();
	}

	@Override
	public void addItem(Student fm) {
		st.save(fm);
		log.info("Saved Student");
	}

	@Override
	public void updateItem(Student fm) {
	st.save(fm);
	log.info("Updating student Data ...");
	}

	@Override
	public Optional<Student> getItemById(int id) {
		log.info("Returning Student with Id "+id);
		return st.findById(id);
	}

	@Override
	public Student findAllById(Iterable<Integer> ids) {
		log.info("Returning Students with Id's "+ids);
		return (Student) st.findAllById(ids);
	}

	@Override
	public void removeItem(int id) {
		st.deleteById(id);
		log.info("Deleting Student with Id "+id+"  ...");
	}

	@Override
	public void removeItemByName(Student bio) {
	    st.delete(bio);
	    log.info("Deleting   "+bio.getName());
		
	}

	@Override
	public void removeAllItems() {
		st.deleteAll();
		log.info("Attention you have deleted ALL Students ");
	}

}
