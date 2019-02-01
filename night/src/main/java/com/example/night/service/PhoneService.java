package com.example.night.service;

import java.util.List;

import com.example.night.model.Phone;

public interface PhoneService {
	public List<Phone> getPhones();

	public void savePhone(Phone thePhone );

	public Phone getPhone(long theId);

	public void deletePhone(long theId);
	public void addPhone(Phone thePhone);
}
