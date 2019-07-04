package com.school.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.school.model.Student;
@Repository
public interface StudentPagingDaoImpl extends 
BaseDao ,PagingAndSortingRepository<Student,Integer>{

}
