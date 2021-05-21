package com.example.murojatnoma;

import java.util.Arrays;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.murojatnoma.entity.CsvFile;
import com.example.murojatnoma.entity.repository.CsvFileRepository;

@SpringBootApplication
public class MurojaatnomaApplication {

	@Autowired
	private CsvFileRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(MurojaatnomaApplication.class, args);
	}

//	@PostConstruct
//	public void initData() {
//
//		repository.saveAll(Arrays.asList(new CsvFileEntity("100.1", "name_100.1", new Date()),
//										new CsvFileEntity("100.2", "name_100.2", new Date()),
//										new CsvFileEntity("90.1", "name_90.1", new Date())));
//
//	}
}
