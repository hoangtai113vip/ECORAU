package com.example.night.dao;

import java.util.List;


import com.example.night.model.Phone;

public interface PhoneDAO {
	public List<Phone> getPhone();

	public void savePhone(Phone thePhone );
	public void addPhone(Phone thePhone);
	public Phone getPhone(long theId);

	public void deletePhone(long theId);
}
