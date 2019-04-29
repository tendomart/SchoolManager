package com.school.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.school.model.InstallmentPayments;
@Service
@Qualifier("installmentPaymentsServiceImpl")
public class InstallmentPaymentsServiceImpl implements EntityService<InstallmentPayments> {

	@Override
	public Iterable<InstallmentPayments> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addItem(InstallmentPayments fm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItem(InstallmentPayments fm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<InstallmentPayments> getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InstallmentPayments findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeItem(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeItemByName(InstallmentPayments bio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAllItems() {
		// TODO Auto-generated method stub
		
	}

}
