package com.example.murojatnoma.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "csv_file_parent")
public class CsvFileChild {

//	@Id
//	@Column(name = "id")
	private String id;
//	@Column(name = "name")
	private String name;
//	@Column(name = "doc_date")
	private String doc_date;
	
	

}
