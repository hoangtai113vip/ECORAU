package com.example.night.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.night.dao.CustomerDAO;
import com.example.night.dao.PhoneDAO;
import com.example.night.model.Customer;
import com.example.night.model.Phone;


@Service
public class PhoneServiceImpl implements PhoneService {

	@Autowired
	private PhoneDAO phoneDAO;
	
	@Override
	@Transactional
	public List<Phone> getPhones() {
		return phoneDAO.getPhone();
	}

	@Override
	@Transactional
	public void savePhone(Phone thePhone) {

		phoneDAO.savePhone(thePhone);
	}

	@Override
	@Transactional
	public Phone getPhone(long theId) {
		
		return phoneDAO.getPhone(theId);
	}

	@Override
	@Transactional
	public void deletePhone(long theId) {
		
		phoneDAO.deletePhone(theId);
	}

	@Override
	@Transactional
	public void addPhone(Phone thePhone) {
		// TODO Auto-generated method stub
		phoneDAO.addPhone(thePhone);
		
	}

}
