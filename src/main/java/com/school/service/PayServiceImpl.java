package com.school.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.school.model.Pay;
import com.school.repository.PayDaoImpl;

@Service
@Qualifier("payServiceImpl")
public class PayServiceImpl implements EntityService<Pay> {
	public static final Logger log = LogManager.getLogger("com.school.service.PayServiceImpl");
	@Autowired
	public PayDaoImpl pay;
	@Override
	public Iterable<Pay> getAllItems() {

		return pay.findAll();
	}

	@Override
	public void addItem(Pay fm) {
	pay.save(fm);
	log.info("Made Payment");
	}

	@Override
	public void updateItem(Pay fm) {
		pay.save(fm);
		log.info("updaed Payment");
	}

	@Override
	public Optional<Pay> getItemById(int id) {
		return pay.findById(id);
	}

	@Override
	public Pay findAllById(Iterable<Integer> ids) {
		return (Pay) pay.findAllById(ids);
	}

	@Override
	public void removeItem(int id) {
		pay.deleteById(id);
		log.info("Remove Payment By Id");
		
	}

	@Override
	public void removeItemByName(Pay bio) {
		pay.delete(bio);
		log.info("Remove Payment by Name");
	}

	@Override
	public void removeAllItems() {
		pay.deleteAll();
		log.info("Delete All Payments");
	}

}
