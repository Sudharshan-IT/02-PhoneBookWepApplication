package com.yadav.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yadav.entity.ContactDtlsEntity;
import com.yadav.model.Contact;
import com.yadav.repository.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService {
	/**
	 * ContactRepository is injected to this 
	 * contact service
	 */
	@Autowired
	private ContactRepository repo;
     /**
      * this is method is meant to perform insert operation on the db table
      */
	@Override
	public boolean saveContact(Contact c) {
		ContactDtlsEntity entity=new ContactDtlsEntity();
		BeanUtils.copyProperties(c, entity);
		ContactDtlsEntity saveEntity = repo.save(entity);
		return saveEntity.getContactId() !=null;
	}
	 /**
     * this is method is meant to perform select operation on the db table
     */
	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contactList=new ArrayList<Contact>();
		List<ContactDtlsEntity> entityList = repo.findAll();
		entityList.forEach(entity ->{
			Contact c=new Contact();
			BeanUtils.copyProperties(entity, c);
			contactList.add(c);
		});
		return contactList;
	}
	 /**
     * this is method is meant to get the contact record based on the on the primary key value
     * To perforn edit operation on db table
     */
	@Override
	public Contact getContactById(Integer cid) {
		Optional<ContactDtlsEntity> optional = repo.findById(cid);
		if(optional.isPresent()) {
			ContactDtlsEntity entity = optional.get();
			Contact c=new Contact();
			BeanUtils.copyProperties(entity, c);
			return c;
		}
		return null;
	}
	/**
	 * this method is used for performing delete operation on the db table
	 */
	@Override
	public boolean deleteContactById(Integer cid) {
		repo.deleteById(cid);
		return true;
	}

}
