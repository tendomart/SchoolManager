package com.school.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.school.model.Student;
@Repository
public interface StudentDaoImpl
extends BaseDao ,CrudRepository<Student, Integer> {

}
