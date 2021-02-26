package com.yadav.service;

import java.util.List;

import com.yadav.model.Contact;

public interface ContactService {

	
	public boolean saveContact(Contact c);
	
	public List<Contact> getAllContacts();
	
	public Contact getContactById(Integer cid);
	
	public boolean deleteContactById(Integer cid);
	
}
