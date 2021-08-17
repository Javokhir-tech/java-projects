package com.springRest.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springRest.contacts.model.Contacts;

public interface ContactsRepository extends JpaRepository<Contacts, Long> {	// data access controller to perform crud operetions on table
}
