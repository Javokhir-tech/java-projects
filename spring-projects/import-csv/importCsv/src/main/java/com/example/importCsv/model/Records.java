package com.example.importCsv.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.collections.ListUtils;

import com.opencsv.bean.CsvBindByName;

@Entity
@Table(name = "records")
public class Records {
    @Id
    @Column(name = "id")
    @CsvBindByName
    private String id;
    
    @Column(name = "name")
    @CsvBindByName
    private String name;

    @Column(name = "date")
    @CsvBindByName
    private String date;

    public Records() {
    }

    public Records(String id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Records [id=" + id + ", name=" + name + ", date=" + date + "]";
    }
    
	// insertion sort
	public static void insertionSort(ArrayList<Records> data) {
		int n = data.size();
		for (int k = 1; k < n; k++) {
			Records currentData = data.get(k);
			String cur = data.get(k).getId();
			int j = k;
			while (j > 0 &&  data.get(j-1).getId().compareTo(cur) > 0) {
				//data.get(j) = data.get(j-1);
				data.set(j, data.get(j-1));
				j--;
			}
			//data.get(j) = currentData;
			data.set(j, currentData);
		}
	} // data[k-1].getId() > cur)
}	// data[k-1].getId().compareTo(cur) > 0

