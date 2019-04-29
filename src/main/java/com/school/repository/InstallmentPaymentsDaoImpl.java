package com.school.repository;

import org.springframework.data.repository.CrudRepository;

import com.school.model.InstallmentPayments;

public interface InstallmentPaymentsDaoImpl 
extends BaseDao ,CrudRepository<InstallmentPayments, Integer>  {

}
