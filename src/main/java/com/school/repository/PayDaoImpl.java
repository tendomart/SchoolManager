package com.school.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.school.model.Pay;
@Repository
public interface PayDaoImpl 
extends BaseDao, CrudRepository<Pay, Integer> {

}
