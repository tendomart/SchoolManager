package com.school.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.school.model.Accounts;
@Service
@Qualifier("accountsServiceImpl")
public class AccountsServiceImpl implements EntityService<Accounts> {

	@Override
	public Iterable<Accounts> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addItem(Accounts fm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItem(Accounts fm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Accounts> getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Accounts findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeItem(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeItemByName(Accounts bio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAllItems() {
		// TODO Auto-generated method stub
		
	}

}
