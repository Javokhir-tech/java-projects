package com.example.importCsv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.importCsv.model.Records;

@Repository
public interface RecordsRepository extends JpaRepository<Records, Integer> {
	
}