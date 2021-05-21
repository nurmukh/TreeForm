package com.example.murojatnoma.service;

import java.io.InputStream;
import java.util.List;

import com.example.murojatnoma.entity.CsvFile;

public interface CsvFileService {

	List<CsvFile> getAllCsvFileEntities();

	void saveCsvFilesAsObject(List<CsvFile> csvFileEntities);

	List<CsvFile> parseCsvToObject(InputStream is);

	List<CsvFile> getAllByIdAsc();

	List<CsvFile> getAllByCurrentId(String id);
}
