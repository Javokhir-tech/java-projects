package com.springRest.contacts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contacts {
	
	@Id
	@SequenceGenerator(sequenceName = "contact_sequence", name = "contact_sequence", allocationSize = 1)	// generates sequence started by 1 incremented by 1
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_sequence")	// create sequence contact_sequence start with 1 increment by  1
	@Column(name = "contact_id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phoneNumber")
	private Long phoneNumber;
	
	public Contacts() {}
	
	public Contacts(String name, Long phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}