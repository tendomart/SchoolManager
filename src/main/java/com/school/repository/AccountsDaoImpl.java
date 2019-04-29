package com.school.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.school.model.Accounts;
@Repository
public interface AccountsDaoImpl 
extends BaseDao ,CrudRepository<Accounts, Integer> {

}
