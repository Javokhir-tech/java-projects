package com.springRest.contacts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springRest.contacts.exception.ContactNotFoundException;
import com.springRest.contacts.model.Contacts;
import com.springRest.contacts.repository.ContactsRepository;

@Service
public class ContactsService {	// logic layer which uses repository interface to access database
	
	@Autowired
	ContactsRepository contactsRepo;
	
	/* get all contacts */
	public List<Contacts> getContacts() {
		return contactsRepo.findAll();
	}
	
	/* get one contact else throw exception */
	public Contacts getContactById(Long id) {
		if (contactsRepo.existsById(id))
			return contactsRepo.findById(id).get();
		throw new ContactNotFoundException(id);
	}
	
	/* create a new contact */
	public void createContact(Contacts contact) {
		contactsRepo.save(contact);
	}
	
	/* update one contact else throw exception */
	public Contacts updateContact(Long id, Contacts contact) {
		if (contactsRepo.existsById(id))
			return contactsRepo.findById(id)
			      .map(employee -> {
			        employee.setName(contact.getName());
			        employee.setPhoneNumber(contact.getPhoneNumber());
			        return contactsRepo.save(employee);
			      })
			      .orElseGet(() -> {
			        contact.setId(id);
			        return contactsRepo.save(contact);
			      });
		throw new ContactNotFoundException(id);
	}
	/* delete one contact else throw exception */
	public void deleteContact(Long id) {
		if (contactsRepo.existsById(id))
			contactsRepo.deleteById(id);
		else
			throw new ContactNotFoundException(id);
	}
}
