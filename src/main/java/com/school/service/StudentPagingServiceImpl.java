package com.school.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.school.model.Student;
@Service
@Qualifier("studentPagingServiceImpl")
public class StudentPagingServiceImpl implements EntityService<Student>{
	private static final Logger log = LogManager.getLogger("com.school.service.StudentPagingServiceImpl");

	@Autowired
	public StudentPagingServiceImpl st;
	@Override
	public Iterable<Student> getAllItems() {
		return st.getAllItems();
	}

	@Override
	public void addItem(Student fm) {
		st.addItem(fm);	
		log.info("Saved Student");
	}

	@Override
	public void updateItem(Student fm) {
		st.updateItem(fm);
	}

	@Override
	public Optional<Student> getItemById(int id) {
		return st.getItemById(id);
	}

	@Override
	public Student findAllById(Iterable<Integer> ids) {
		return st.findAllById(ids);
	}

	@Override
	public void removeItem(int id) {
		st.removeItem(id);
	}

	@Override
	public void removeItemByName(Student bio) {
		st.removeItemByName(bio);
	}

	@Override
	public void removeAllItems() {
		st.removeAllItems();
	}

}
