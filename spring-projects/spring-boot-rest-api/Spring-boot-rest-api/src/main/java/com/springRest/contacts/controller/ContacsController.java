package com.springRest.contacts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.contacts.model.Contacts;
import com.springRest.contacts.service.ContactsService;

@RestController
@RequestMapping("/")
public class ContacsController {
	
	@Autowired
	ContactsService service;
	
	@GetMapping
	public ResponseEntity<List<Contacts>> getContacts() {
		List<Contacts> contacts = service.getContacts();
		return new ResponseEntity<>(contacts, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Contacts> getContact(@PathVariable Long id) {
		Contacts contact = service.getContactById(id);
		return new ResponseEntity<Contacts>(contact, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody Contacts contact) {
		service.createContact(contact);
		return new ResponseEntity<> (String.format("Contact has been created. Status Code: %s", HttpStatus.OK), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody Contacts contact, @PathVariable Long id) {
		service.updateContact(id, contact);
		return new ResponseEntity<>(String.format("Contact has been updated. Status Code: %s", HttpStatus.OK), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.deleteContact(id);
		return new ResponseEntity<>(String.format("Contact has been deleted. Status Code: %s", HttpStatus.OK), HttpStatus.OK);
	}
}