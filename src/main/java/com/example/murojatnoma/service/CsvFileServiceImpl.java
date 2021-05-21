package com.example.murojatnoma.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.murojatnoma.entity.CsvFile;
import com.example.murojatnoma.entity.CsvFileChild;
import com.example.murojatnoma.entity.CsvFileParent;
import com.example.murojatnoma.entity.repository.CsvFileRepository;

@Service
public class CsvFileServiceImpl implements CsvFileService {

	@Autowired
	private CsvFileRepository csvRepo;

	@Override
	public List<CsvFile> getAllCsvFileEntities() {
		return csvRepo.findAll();
	}

	@Override
	public void saveCsvFilesAsObject(List<CsvFile> csvFileEntities) {
		csvRepo.saveAll(csvFileEntities);
	}

	@Override
	public List<CsvFile> parseCsvToObject(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withDelimiter(' ').withTrim());) {

			List<CsvFile> csvFiles = new ArrayList<CsvFile>();
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				
				CsvFile csvFile = new CsvFile((csvRecord.get(0)), csvRecord.get(1), csvRecord.get(2));
				csvFiles.add(csvFile);
			}
			
			ArrayList<CsvFileParent> parents = new ArrayList<>();
			ArrayList<CsvFileChild> child = new ArrayList<>();
			
			
			
			
			return csvFiles;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

	@Override
	public List<CsvFile> getAllByIdAsc() {
		return csvRepo.findByOrderByIdAsc();
	}

	@Override
	public List<CsvFile> getAllByCurrentId(String id) {
		return csvRepo.findByIdContaining(id);
	}
}
