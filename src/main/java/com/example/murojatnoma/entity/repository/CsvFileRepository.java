package com.example.murojatnoma.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.murojatnoma.entity.CsvFile;

@RepositoryRestResource(collectionResourceRel = "csvFiles", path = "csvFiles")
public interface CsvFileRepository extends JpaRepository<CsvFile, String> {

	List<CsvFile> findByOrderByIdAsc();

	List<CsvFile> findByIdContaining(String string);
}
